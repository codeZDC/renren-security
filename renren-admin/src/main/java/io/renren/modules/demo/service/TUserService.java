package io.renren.modules.demo.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.demo.entity.TUserEntity;

import java.util.Map;

/**
 * 
 *
 * @author codeZ
 * @email sunlightcs@gmail.com
 * @date 2018-05-10 16:12:22
 */
public interface TUserService extends IService<TUserEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

