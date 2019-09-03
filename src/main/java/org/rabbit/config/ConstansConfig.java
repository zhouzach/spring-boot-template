package org.rabbit.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
public class ConstansConfig {

    @Value("${sumbit.shell.cmd}")
    private String submitShellCmd;

}
