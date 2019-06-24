/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.webank.webase.transaction.config;

import com.webank.webase.transaction.contract.ContractMapper;
import com.webank.webase.transaction.trans.TransMapper;
import lombok.Data;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class TableInitConfig implements InitializingBean {
    @Autowired
    private ContractMapper contractMapper;
    @Autowired
    private TransMapper transMapper;

    @Override
    public void afterPropertiesSet() throws Exception {
        contractMapper.createTbDeployTrans();;
        transMapper.createTbStatelessTrans();;
    }
}
