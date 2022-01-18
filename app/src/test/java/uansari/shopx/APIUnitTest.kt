package uansari.shopx

import junit.framework.Assert.assertEquals
import org.junit.Test
import uansari.shopx.utils.Constants.BASE_URL

class APIUnitTest {
    @Test
    fun checkBaseUrl() {
        assertEquals(BASE_URL, "https://fakestoreapi.com/")
    }
}