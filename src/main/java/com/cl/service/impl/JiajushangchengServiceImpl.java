package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.JiajushangchengDao;
import com.cl.entity.JiajushangchengEntity;
import com.cl.service.JiajushangchengService;
import com.cl.entity.view.JiajushangchengView;

@Service("jiajushangchengService")
public class JiajushangchengServiceImpl extends ServiceImpl<JiajushangchengDao, JiajushangchengEntity> implements JiajushangchengService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JiajushangchengEntity> page = this.selectPage(
                new Query<JiajushangchengEntity>(params).getPage(),
                new EntityWrapper<JiajushangchengEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JiajushangchengEntity> wrapper) {
		  Page<JiajushangchengView> page =new Query<JiajushangchengView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<JiajushangchengView> selectListView(Wrapper<JiajushangchengEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JiajushangchengView selectView(Wrapper<JiajushangchengEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
