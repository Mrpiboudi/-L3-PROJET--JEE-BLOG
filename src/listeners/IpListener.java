package listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * When a user sends a request with a different IP or user-agent
 * string, we destroy its session.
 * 
 * It aims to mitigate the risk of session hijacking. A user should
 * have the same user-agent during all its session, because the
 * user-agent is a string (HTTP header "User-Agent") corresponding to the
 * agent (Web browser) sending the request. The IP address is usually the
 * same during all the session, even if it's practically possible to switch
 * from Wi-Fi to 3G, so from router's IP to phone's one.
 */
@WebListener
public class IpListener implements HttpSessionAttributeListener {
	
    /**
     * Invalidate the session if the attribute "ip" or "user-agent" is
     * updated.
     * 
     * @param se HttpSessionBindingEvent
     */
    public void attributeReplaced(HttpSessionBindingEvent se)
    {
	HttpSession session = se.getSession();
	// This method is called every time any session attribute is called
	// so we have to check if the changed attribute is interesting for
	// us. If the attribute is "ip" or "user-agent", we suspect something
	// malicious, it's safer to disconnect this user.
	if (se.getName().equals("ip") || se.getName().equals("user-agent")) {
	    session.invalidate();
	}
    }
}
