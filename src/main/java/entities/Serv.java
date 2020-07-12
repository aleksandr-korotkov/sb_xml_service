package entities;

import lombok.Getter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

@Getter
@ToString
public class Serv {
    @XmlAttribute
    private int isClosed;
    @XmlElement(name = "serv_id")
    private String servId;
    @XmlElement
    private Long bic;
    @XmlElement
    private String schet;
    @XmlElement(name = "corr_schet")
    private String corrSchet;
    @XmlElementWrapper(name = "pars")
    @XmlElement(name = "par")
    private List<Par> pars;
    @XmlElement(name = "sys_message")
    private String sysMessage;
}
