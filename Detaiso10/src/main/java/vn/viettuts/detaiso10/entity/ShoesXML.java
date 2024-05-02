package vn.viettuts.detaiso10.entity;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "sanpham")
@XmlAccessorType(XmlAccessType.FIELD)
public class ShoesXML {
    private List<Shoes> shoes;

    public List<Shoes> getShoes() {
        return shoes;
    }

    public void setShoes(List<Shoes> shoes) {
        this.shoes = shoes;
    }
}
