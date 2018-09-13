package com.qf.oa.service;

import com.qf.oa.entity.Resc;

import java.util.List;

public interface IRescService {
    List<Resc> queryAll();

    void insertResc(Resc resc);

    List<Resc> queryresc(Integer rid);

    int updateRescAndRole(Integer rid, Integer[] reids);
}
