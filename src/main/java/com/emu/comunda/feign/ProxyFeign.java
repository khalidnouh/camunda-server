package com.emu.comunda.feign;

import com.emu.comunda.client.AuthorizedFeignClient;
import org.springframework.web.bind.annotation.GetMapping;
/**
 * Copyright 2021-2022 By Dirac Systems.
 *
 * Created by khalid.nouh on 17/3/2021.
 */

@AuthorizedFeignClient(name = "proxy")
public interface ProxyFeign {
        @GetMapping("/api/get")
        String get();
}
