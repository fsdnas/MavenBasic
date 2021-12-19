package com.mobile.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mobile.exceptions.IdNotFoundException;
import com.mobile.exceptions.MobileNotFoundException;
import com.mobile.model.Mobile;
import com.mysql.cj.exceptions.ConnectionIsClosedException;

public class MobileRepositoryImpl implements IMobileRepository {
	static Connection connection;

	@Override
	public void addMobile(Mobile mobile) {
		connection = ModelDAO.openConnection();
		PreparedStatement statement = null;

		try {
			statement = connection.prepareStatement(Queries.INSERTQUERY);
			statement.setString(1, mobile.getModel());
			statement.setString(2, mobile.getBrand());
			statement.setString(3, mobile.getos());
			statement.setFloat(4, mobile.getPrice());
			statement.setString(5, mobile.getStorage());
			statement.execute();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (statement != null) {

				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				ModelDAO.closeConnection();
			}

		}

	}

	@Override
	public void updateMobile(int mobileId, float price) throws IdNotFoundException {
		connection = ModelDAO.openConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(Queries.UPDATEQUERY);
			statement.setFloat(1, price);
			statement.setInt(2, mobileId);

			int count = statement.executeUpdate();
			if (count == 0) {
				throw new IdNotFoundException("Mobile id not found");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				ModelDAO.closeConnection();
			}

		}

	}

	@Override
	public Mobile findById(int mobileId) throws IdNotFoundException {

		PreparedStatement statement = null;
		Mobile mobile = null;
		Connection connection = ModelDAO.openConnection();

		try {
			statement = connection.prepareStatement(Queries.SELECTBYIDQUERY);
			statement.setInt(1, mobileId);
			ResultSet resultset = null;
			resultset = statement.executeQuery();
			while (resultset.next()) {
				mobile = new Mobile();
				mobile.setBrand(resultset.getString("brand"));
				mobile.setModel(resultset.getString("model"));
				mobile.setStorage(resultset.getString("storage"));
				mobile.setMobileId(resultset.getInt("mobileid"));
				mobile.setos(resultset.getString("os"));
				mobile.setPrice(resultset.getFloat("price"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				ModelDAO.closeConnection();
			}

		}

		return mobile;
	}

	@Override
	public void deleteMobile(int mobileId) throws IdNotFoundException {
		PreparedStatement statement = null;
		connection = ModelDAO.openConnection();
		try {
			statement = connection.prepareStatement(Queries.DELETEQUERY);
			statement.setInt(1, mobileId);
			boolean result = statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ModelDAO.closeConnection();
			}
		}

	}

	@Override
	public List<Mobile> findAllMobiles() {
		PreparedStatement statement = null;
		Connection connection = ModelDAO.openConnection();
		ResultSet resultset = null;
		List<Mobile> mobileList = new ArrayList<>();

		try {
			statement = connection.prepareStatement(Queries.SELECTALLQUERY);
			resultset = statement.executeQuery();
			while (resultset.next()) {
				String model = resultset.getString("model");
				String brand = resultset.getString("brand");
				String os = resultset.getString("os");
				Float price = resultset.getFloat("price");
				String storage = resultset.getString("storage");

				Mobile mobile = new Mobile(model, brand, storage, os, price);
				mobile.setMobileId(resultset.getInt("mobileid"));
				mobileList.add(mobile);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				ModelDAO.closeConnection();
			}

		}
		return mobileList;

	}

	@Override
	public List<Mobile> findByBrand(String brand) throws MobileNotFoundException {
		PreparedStatement statement = null;
		Connection connection = ModelDAO.openConnection();
		ResultSet resultset = null;
		List<Mobile> mobileList = new ArrayList<>();

		try {
			statement = connection.prepareStatement(Queries.GETBYBRANDQUERY);

			statement.setString(1, brand);
			resultset = statement.executeQuery();
			while (resultset.next()) {
				String model = resultset.getString("model");
				String branded = resultset.getString("brand");
				String os = resultset.getString("os");
				Float price = resultset.getFloat("price");
				String storage = resultset.getString("storage");

				Mobile mobile = new Mobile(model, branded, storage, os, price);
				mobile.setMobileId(resultset.getInt("mobileid"));
				mobileList.add(mobile);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (mobileList.isEmpty()) {
			throw new MobileNotFoundException("Mobile not found");
		}
		return mobileList;
	}

	@Override
	public List<Mobile> findByBrandAndModelStarting(String brand, String model) throws MobileNotFoundException {
		PreparedStatement statement = null;
		Connection connection = ModelDAO.openConnection();
		ResultSet resultset = null;
		List<Mobile> mobileList = new ArrayList<>();

		try {
			statement = connection.prepareStatement(Queries.GETBRANDMODELQUERY);

			statement.setString(1, brand);
			statement.setString(2, model + "%");
			resultset = statement.executeQuery();
			while (resultset.next()) {
				String searchedModel = resultset.getString("model");
				String searchedbrand = resultset.getString("brand");
				String os = resultset.getString("os");
				Float price = resultset.getFloat("price");
				String storage = resultset.getString("storage");

				Mobile mobile = new Mobile(searchedModel, searchedbrand, storage, os, price);
				mobile.setMobileId(resultset.getInt("mobileid"));
				mobileList.add(mobile);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				ModelDAO.closeConnection();
			}

		}

		if (mobileList.isEmpty()) {
			throw new MobileNotFoundException("Mobile not found");
		}
		return mobileList;
	}

	@Override
	public List<Mobile> findByOS(String OS) throws MobileNotFoundException {
		PreparedStatement statement = null;
		Connection connection = ModelDAO.openConnection();
		ResultSet resultset = null;
		List<Mobile> mobileList = new ArrayList<>();

		try {
			statement = connection.prepareStatement(Queries.GETBYOSQUERY);

			statement.setString(1, OS);
			resultset = statement.executeQuery();
			while (resultset.next()) {
				String model = resultset.getString("model");
				String branded = resultset.getString("brand");
				String os = resultset.getString("os");
				Float price = resultset.getFloat("price");
				String storage = resultset.getString("storage");

				Mobile mobile = new Mobile(model, branded, storage, os, price);
				mobile.setMobileId(resultset.getInt("mobileid"));
				mobileList.add(mobile);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				ModelDAO.closeConnection();
			}

		}

		if (mobileList.isEmpty()) {
			throw new MobileNotFoundException("Mobile not found");
		}
		return mobileList;
	}

	@Override
	public List<Mobile> findByLesserPrice(double lowPrice) throws MobileNotFoundException {
		PreparedStatement statement = null;
		Connection connection = ModelDAO.openConnection();
		ResultSet resultset = null;
		List<Mobile> mobileList = new ArrayList<>();

		try {
			statement = connection.prepareStatement(Queries.GETPRICEQUERY);

			statement.setDouble(1, lowPrice);
			resultset = statement.executeQuery();
			while (resultset.next()) {
				String model = resultset.getString("model");
				String branded = resultset.getString("brand");
				String os = resultset.getString("os");
				Float price = resultset.getFloat("price");
				String storage = resultset.getString("storage");

				Mobile mobile = new Mobile(model, branded, storage, os, price);
				mobile.setMobileId(resultset.getInt("mobileid"));
				mobileList.add(mobile);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				ModelDAO.closeConnection();
			}

		}

		if (mobileList.isEmpty()) {
			throw new MobileNotFoundException("Mobile not found");
		}
		return mobileList;
	}

}
