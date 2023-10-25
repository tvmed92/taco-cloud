package tm.tacos

import org.hamcrest.CoreMatchers.containsString
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@WebMvcTest
class HomeControllerTest(
        @Autowired
        private val mockMvc: MockMvc
) {
    @Test
    fun testHomePage() {
        mockMvc.get("/")
                .andExpect { status { isOk() } }
                .andExpect { view { name("home") } }
                .andExpect { content { string(containsString("Welcome to...")) } }
    }
}