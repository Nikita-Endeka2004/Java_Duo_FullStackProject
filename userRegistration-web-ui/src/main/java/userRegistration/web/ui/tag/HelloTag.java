package userRegistration.web.ui.tag;

import com.sun.jna.platform.unix.solaris.LibKstat;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.jstl.fmt.LocaleSupport;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.time.LocalTime;

public class HelloTag extends TagSupport {
    private String name = null;

    @Override
    public int doStartTag() throws JspException {
        LocaleSupport localeSupport = new LocaleSupport();
        String goodMorningMessage = localeSupport.getLocalizedMessage(pageContext, "goodmorning_message");
        String goodAfternoonMessage = localeSupport.getLocalizedMessage(pageContext, "goodafternoon_message");
        String prefix = goodMorningMessage + ", ";
        if (LocalTime.now().isAfter(LocalTime.NOON)) {
            prefix = goodAfternoonMessage + ", ";
        }
        try {
            if (name == null || name.isEmpty()) {
                pageContext.getOut().write(prefix + "anonymous");
            } else {
                pageContext.getOut().write(prefix + name);
            }
        } catch (IOException e) {
            throw new JspException(e.getMessage());
        }
        return SKIP_BODY;
    }

    @Override
    public void release() {
        super.release();
        this.name = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
