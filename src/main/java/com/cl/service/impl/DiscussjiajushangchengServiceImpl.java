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


import com.cl.dao.DiscussjiajushangchengDao;
import com.cl.entity.DiscussjiajushangchengEntity;
import com.cl.service.DiscussjiajushangchengService;
import com.cl.entity.view.DiscussjiajushangchengView;

@Service("discussjiajushangchengService")
public class DiscussjiajushangchengServiceImpl extends ServiceImpl<DiscussjiajushangchengDao, DiscussjiajushangchengEntity> implements DiscussjiajushangchengService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussjiajushangchengEntity> page = this.selectPage(
                new Query<DiscussjiajushangchengEntity>(params).getPage(),
                new EntityWrapper<DiscussjiajushangchengEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussjiajushangchengEntity> wrapper) {
		  Page<DiscussjiajushangchengView> page =new Query<DiscussjiajushangchengView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DiscussjiajushangchengView> selectListView(Wrapper<DiscussjiajushangchengEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussjiajushangchengView selectView(Wrapper<DiscussjiajushangchengEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
