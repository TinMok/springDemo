package com.nufront.euht.service.impl;

import com.nufront.euht.dao.AccountMapper;
import com.nufront.euht.model.Account;
import com.nufront.euht.service.api.IAccountService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Mo Xiyong
 * @since 2018-03-12
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements IAccountService {

}
