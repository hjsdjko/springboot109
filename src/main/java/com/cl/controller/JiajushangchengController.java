package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.JiajushangchengEntity;
import com.cl.entity.view.JiajushangchengView;

import com.cl.service.JiajushangchengService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;
import com.cl.service.StoreupService;
import com.cl.entity.StoreupEntity;

/**
 * 家具商城
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-09 14:13:05
 */
@RestController
@RequestMapping("/jiajushangcheng")
public class JiajushangchengController {
    @Autowired
    private JiajushangchengService jiajushangchengService;

    @Autowired
    private StoreupService storeupService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JiajushangchengEntity jiajushangcheng,
		HttpServletRequest request){
        EntityWrapper<JiajushangchengEntity> ew = new EntityWrapper<JiajushangchengEntity>();

		PageUtils page = jiajushangchengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiajushangcheng), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JiajushangchengEntity jiajushangcheng, 
		HttpServletRequest request){
        EntityWrapper<JiajushangchengEntity> ew = new EntityWrapper<JiajushangchengEntity>();

		PageUtils page = jiajushangchengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiajushangcheng), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JiajushangchengEntity jiajushangcheng){
       	EntityWrapper<JiajushangchengEntity> ew = new EntityWrapper<JiajushangchengEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiajushangcheng, "jiajushangcheng")); 
        return R.ok().put("data", jiajushangchengService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JiajushangchengEntity jiajushangcheng){
        EntityWrapper< JiajushangchengEntity> ew = new EntityWrapper< JiajushangchengEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiajushangcheng, "jiajushangcheng")); 
		JiajushangchengView jiajushangchengView =  jiajushangchengService.selectView(ew);
		return R.ok("查询家具商城成功").put("data", jiajushangchengView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JiajushangchengEntity jiajushangcheng = jiajushangchengService.selectById(id);
		jiajushangcheng = jiajushangchengService.selectView(new EntityWrapper<JiajushangchengEntity>().eq("id", id));
        return R.ok().put("data", jiajushangcheng);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JiajushangchengEntity jiajushangcheng = jiajushangchengService.selectById(id);
		jiajushangcheng = jiajushangchengService.selectView(new EntityWrapper<JiajushangchengEntity>().eq("id", id));
        return R.ok().put("data", jiajushangcheng);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JiajushangchengEntity jiajushangcheng, HttpServletRequest request){
    	jiajushangcheng.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiajushangcheng);
        jiajushangchengService.insert(jiajushangcheng);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JiajushangchengEntity jiajushangcheng, HttpServletRequest request){
    	jiajushangcheng.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiajushangcheng);
        jiajushangchengService.insert(jiajushangcheng);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JiajushangchengEntity jiajushangcheng, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiajushangcheng);
        jiajushangchengService.updateById(jiajushangcheng);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jiajushangchengService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
