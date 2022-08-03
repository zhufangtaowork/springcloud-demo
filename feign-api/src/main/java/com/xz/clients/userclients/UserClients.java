package com.xz.clients.userclients;


import com.xz.entity.commonview.ResultView;
import com.xz.entity.user.dto.UserInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ClassName： UserClients
 * @Description： 暴露用户服务接口
 * @Date： 2022/7/29 下午7:08
 * @author： ZhuFangTao
 */
@FeignClient(value = "user-service")
public interface UserClients {
    @GetMapping("/api/user/{id}")
    ResultView<UserInfo> byUserIdGetUserInfo(@PathVariable Integer id);
}
