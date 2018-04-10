package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {
    private String port;
    private String memory_limit;
    private String cf_instance_index;
    private String cf_instance_addr;
    public EnvController (@Value("${PORT:NOT SET}") String my_port,
                          @Value("${MEMORY_LIMIT:NOT SET}") String my_memory_limit,
                          @Value("${CF_INSTANCE_INDEX:NOT SET}") String my_cf_instance_index,
                          @Value("${CF_INSTANCE_ADDR:NOT SET}") String my_cf_instance_addr) {
        this.port = my_port;
        this.memory_limit = my_memory_limit;
        this.cf_instance_index = my_cf_instance_index;
        this.cf_instance_addr = my_cf_instance_addr;
    }

    @GetMapping("/env")
    public Map<String, String> getEnv() throws Exception {
        Map<String, String> env = new HashMap<String, String>();
        env.put("PORT",this.port);
        env.put("MEMORY_LIMIT",this.memory_limit);
        env.put("CF_INSTANCE_INDEX",this.cf_instance_index);
        env.put("CF_INSTANCE_ADDR",this.cf_instance_addr);
        return env;
    }
}
