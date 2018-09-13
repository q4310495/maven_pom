package com.qf.oa.service;

import com.qf.oa.entity.Role;

import java.util.List;

public interface IRoleService {

    public List<Role> queryAll();

    List<Role> queryRoleById(Integer eid);

    int selectroles(Integer eid, Integer[] rid);

    int insertRole(Role role);
}
