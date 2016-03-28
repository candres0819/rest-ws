package com.carloscardona.ws.rest.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.carloscardona.ws.rest.model.User;

/**
 * 
 * @author candr
 *
 */
public class UserDAOImpl implements UserDAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserDAOImpl.class);

	@SuppressWarnings("unchecked")
	@Override
	public List<User> all() {
		List<User> userList = null;
		File file = null;
		try {
			file = new File("Users.dat");
			if (!file.exists()) {
				userList = new ArrayList<User>();
				User user = new User(1, "Mahesh", "Teacher");
				userList.add(user);
				saveUserList(userList);
			} else {
				FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);
				userList = (List<User>) ois.readObject();
				ois.close();
			}
		} catch (IOException e) {
			LOGGER.error("Error al consultar los usuarios", e);
		} catch (ClassNotFoundException e) {
			LOGGER.error("Error al consultar los usuarios", e);
		}
		return userList;
	}

	@Override
	public void save(User user) {
		File file = null;
		try {
			file = new File("Users.dat");
			if (!file.exists()) {
				throw new Exception();
			} else {
				FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);
				List<User> userList = (List<User>) ois.readObject();
				userList.add(user);
				ois.close();
				saveUserList(userList);
			}
		} catch (Exception e) {
			LOGGER.error("Error al guardar un usuario", e);
		}
	}

	/**
	 * 
	 * @param userList
	 */
	private void saveUserList(List<User> userList) {
		try {
			File file = new File("Users.dat");
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(userList);
			oos.close();
		} catch (FileNotFoundException e) {
			LOGGER.error("Error al consultar los usuarios", e);
		} catch (IOException e) {
			LOGGER.error("Error al consultar los usuarios", e);
		}
	}
}