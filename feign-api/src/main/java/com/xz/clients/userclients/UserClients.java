package com.xz.clients.userclients;


import com.xz.entity.commonview.ResultPageView;
import com.xz.entity.commonview.ResultView;
import com.xz.entity.user.dto.UserInfo;
import com.xz.entity.user.po.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;

/**
 * @ClassName： UserClients
 * @Description： 暴露用户服务接口
 * @Date： 2022/7/29 下午7:08
 * @author： ZhuFangTao
 */
@FeignClient(value = "user-service")
public interface UserClients {

    @PostMapping(value = "api/user/list")
    public ResultPageView<List<UserInfo>> getUserList(@RequestBody HashMap<String,Object> params);
}
