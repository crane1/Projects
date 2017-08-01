package com.lizem.check_right.service;

import com.lizem.check_right.bean.Student;

public interface ILoginService {
	Student checkUserExist(int id, String pwd);
}
