package jobsite.account;

import jobsite.config.WebSecurityConfigurationAware;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;

import jakarta.servlet.http.HttpSession;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

public class UserAuthenticationIntegrationTest extends WebSecurityConfigurationAware {

    private static String SEC_CONTEXT_ATTR = HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY;

    @Test
    public void requiresAuthentication() throws Exception {
        mockMvc.perform(get("/account/current"))
                .andExpect(redirectedUrl("http://localhost/signin"));
    }

    @Test
    public void userAuthenticates() throws Exception {
        final String username = "user";
        ResultMatcher matcher = new ResultMatcher() {
            public void match(MvcResult mvcResult) throws Exception {
                Object session = mvcResult.getRequest().getSession();
                SecurityContext securityContext = (SecurityContext) ((jakarta.servlet.http.HttpSession)session).getAttribute(SEC_CONTEXT_ATTR);
                Assertions.assertEquals(username, securityContext.getAuthentication().getName());
            }
        };
        mockMvc.perform(post("/j_spring_security_check").with(csrf()).param("j_username", username).param("j_password", "demo"))
                .andExpect(redirectedUrl("/"))
                .andExpect(matcher);
    }

    @Test
    public void userAuthenticationFails() throws Exception {
        final String username = "user";
        mockMvc.perform(post("/j_spring_security_check").with(csrf()).param("j_username", username).param("j_password", "invalid"))
                .andExpect(redirectedUrl("/signin?error=1"))
                .andExpect(new ResultMatcher() {
                    public void match(MvcResult mvcResult) throws Exception {
                        jakarta.servlet.http.HttpSession session = mvcResult.getRequest().getSession();
                        SecurityContext securityContext = (SecurityContext) session.getAttribute(SEC_CONTEXT_ATTR);
                        Assertions.assertNull(securityContext);
                    }
                });
    }
}
