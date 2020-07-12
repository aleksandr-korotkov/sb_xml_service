package entities;

import lombok.Getter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;
import java.util.List;

@ToString
@Getter
public class Par {
    @XmlAttribute
    private int step;
    @XmlAttribute
    private String name;
    @XmlAttribute(name = "fullname")
    private String fullName;
    @XmlAttribute
    private String comment;
    @XmlAttribute
    private int isEditable;
    @XmlAttribute
    private int isScanable;
    @XmlAttribute
    private int isVisible;
    @XmlAttribute
    private int isRequired;
    @XmlAttribute
    private int isPrinted;
    @XmlAttribute
    private int isValidateOnLine;
    @XmlAttribute
    private String type;
    @XmlAttribute(name = "min_length")
    private int minLength;
    @XmlAttribute(name = "max_length")
    private int maxLength;
    @XmlAttribute(name = "double_input")
    private BigDecimal doubleInput;
    @XmlAttribute
    private String value;
    @XmlAttribute(name = "reg_exp")
    private String regExp;
    @XmlAttribute(name = "from_debt")
    private int fromDebt;
    @XmlElement(name = "par_list")
    private List<ParList> parList;
}
