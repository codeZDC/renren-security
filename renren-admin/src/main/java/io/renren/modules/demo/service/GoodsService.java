package io.renren.modules.demo.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.demo.entity.GoodsEntity;

import java.util.Map;

/**
 * 商品管理
 *
 * @author codeZ
 * @email sunlightcs@gmail.com
 * @date 2018-05-10 14:42:41
 */
public interface GoodsService extends IService<GoodsEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

