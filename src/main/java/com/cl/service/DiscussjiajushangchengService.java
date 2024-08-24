package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DiscussjiajushangchengEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussjiajushangchengView;


/**
 * 家具商城评论表
 *
 * @author 
 * @email 
 * @date 2024-03-09 14:13:05
 */
public interface DiscussjiajushangchengService extends IService<DiscussjiajushangchengEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussjiajushangchengView> selectListView(Wrapper<DiscussjiajushangchengEntity> wrapper);
   	
   	DiscussjiajushangchengView selectView(@Param("ew") Wrapper<DiscussjiajushangchengEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussjiajushangchengEntity> wrapper);
   	

}

