package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.JiajushangchengEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JiajushangchengView;


/**
 * 家具商城
 *
 * @author 
 * @email 
 * @date 2024-03-09 14:13:05
 */
public interface JiajushangchengService extends IService<JiajushangchengEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiajushangchengView> selectListView(Wrapper<JiajushangchengEntity> wrapper);
   	
   	JiajushangchengView selectView(@Param("ew") Wrapper<JiajushangchengEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiajushangchengEntity> wrapper);
   	

}

