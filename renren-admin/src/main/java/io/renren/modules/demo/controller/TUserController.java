package io.renren.modules.demo.controller;

import java.util.Arrays;
import java.util.Map;

import io.renren.common.validator.ValidatorUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.demo.entity.TUserEntity;
import io.renren.modules.demo.service.TUserService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author codeZ
 * @email sunlightcs@gmail.com
 * @date 2018-05-10 16:12:22
 */
@RestController
@RequestMapping("demo/tuser")
public class TUserController {
    @Autowired
    private TUserService tUserService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("demo:tuser:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = tUserService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("demo:tuser:info")
    public R info(@PathVariable("id") Integer id){
        TUserEntity tUser = tUserService.selectById(id);

        return R.ok().put("tUser", tUser);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("demo:tuser:save")
    public R save(@RequestBody TUserEntity tUser){
        tUserService.insert(tUser);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("demo:tuser:update")
    public R update(@RequestBody TUserEntity tUser){
        ValidatorUtils.validateEntity(tUser);
        tUserService.updateAllColumnById(tUser);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("demo:tuser:delete")
    public R delete(@RequestBody Integer[] ids){
        tUserService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
