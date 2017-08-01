package com.lizem.check_right.dao;

import com.lizem.check_right.bean.Student;

public interface ILoginDAO {
	Student checkUserExist(int id, String pwd);
}
