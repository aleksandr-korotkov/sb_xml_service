package entities;

import lombok.Getter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAttribute;

@ToString
@Getter
public class ParList {
    @XmlAttribute
    private String value;
}
