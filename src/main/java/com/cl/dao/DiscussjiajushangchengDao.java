package com.cl.dao;

import com.cl.entity.DiscussjiajushangchengEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussjiajushangchengView;


/**
 * 家具商城评论表
 * 
 * @author 
 * @email 
 * @date 2024-03-09 14:13:05
 */
public interface DiscussjiajushangchengDao extends BaseMapper<DiscussjiajushangchengEntity> {
	
	List<DiscussjiajushangchengView> selectListView(@Param("ew") Wrapper<DiscussjiajushangchengEntity> wrapper);

	List<DiscussjiajushangchengView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussjiajushangchengEntity> wrapper);
	
	DiscussjiajushangchengView selectView(@Param("ew") Wrapper<DiscussjiajushangchengEntity> wrapper);
	

}
