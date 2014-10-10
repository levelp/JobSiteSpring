package jobsite.config;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.security.web.FilterChainProxy;

import jakarta.inject.Inject;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

public abstract class WebSecurityConfigurationAware extends WebAppConfigurationAware {

    @Inject
    private FilterChainProxy springSecurityFilterChain;

    @BeforeEach
    public void beforeEach() {
        this.mockMvc = webAppContextSetup(this.wac)
                .addFilters(this.springSecurityFilterChain).build();
    }
}
