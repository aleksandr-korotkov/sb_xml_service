package entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.util.List;

@XmlRootElement
@Getter
@NoArgsConstructor
@ToString
public class RootElement {
    @XmlElementWrapper(name = "services")
    @XmlElement(name = "serv")
    private List<Serv> services;
    @XmlElement
    private BigDecimal summa;
}