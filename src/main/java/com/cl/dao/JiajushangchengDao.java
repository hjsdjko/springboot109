package com.cl.dao;

import com.cl.entity.JiajushangchengEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JiajushangchengView;


/**
 * 家具商城
 * 
 * @author 
 * @email 
 * @date 2024-03-09 14:13:05
 */
public interface JiajushangchengDao extends BaseMapper<JiajushangchengEntity> {
	
	List<JiajushangchengView> selectListView(@Param("ew") Wrapper<JiajushangchengEntity> wrapper);

	List<JiajushangchengView> selectListView(Pagination page,@Param("ew") Wrapper<JiajushangchengEntity> wrapper);
	
	JiajushangchengView selectView(@Param("ew") Wrapper<JiajushangchengEntity> wrapper);
	

}
