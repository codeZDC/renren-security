package io.renren.modules.demo.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.demo.dao.TUserDao;
import io.renren.modules.demo.entity.TUserEntity;
import io.renren.modules.demo.service.TUserService;


@Service("tUserService")
public class TUserServiceImpl extends ServiceImpl<TUserDao, TUserEntity> implements TUserService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TUserEntity> page = this.selectPage(
                new Query<TUserEntity>(params).getPage(),
                new EntityWrapper<TUserEntity>()
        );

        return new PageUtils(page);
    }

}
