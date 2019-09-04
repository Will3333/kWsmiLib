package pro.wsmi.kwsmilib.test.net

import pro.wsmi.kwsmilib.net.ipv4Regex
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

@Test
fun ipv4RegexTest()
{
    val t1Ipv4 = "192.168.1.92"
    assertTrue(ipv4Regex.matches(t1Ipv4), "Test $t1Ipv4")

    val t5Ipv4 = "3.5.1.6"
    assertTrue(ipv4Regex.matches(t5Ipv4), "Test $t5Ipv4")

    val t2Ipv4 = "13.58.4.2225"
    assertFalse(ipv4Regex.matches(t2Ipv4), "Test $t2Ipv4")

    val t3Ipv4 = "1.168.1.92.5"
    assertFalse(ipv4Regex.matches(t3Ipv4), "Test $t3Ipv4")

    val t4Ipv4 = "168.20.92"
    assertFalse(ipv4Regex.matches(t4Ipv4), "Test $t4Ipv4")
}