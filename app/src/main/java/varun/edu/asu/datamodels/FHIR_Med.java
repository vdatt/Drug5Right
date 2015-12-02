package varun.edu.asu.datamodels;
/**
 * Created by Varun on 11/27/2015.
 */

public class FHIR_Med {
    private String NDC;
    private String name;
    private int dose;
    private String doseUnits;
    private String routeOfAdmin;
    private String packaging;

    public String getNDC() {
        return NDC;
    }

    public void setNDC(String NDC) {
        this.NDC = NDC;
    }

    public int getDose() {
        return dose;
    }

    public void setDose(int dose) {
        this.dose = dose;
    }

    public String getDoseUnits() {
        return doseUnits;
    }

    public void setDoseUnits(String doseUnits) {
        this.doseUnits = doseUnits;
    }

    public String getRouteOfAdmin() {
        return routeOfAdmin;
    }

    public void setRouteOfAdmin(String routeOfAdmin) {
        this.routeOfAdmin = routeOfAdmin;
    }

    public String getPackaging() {
        return packaging;
    }

    public void setPackaging(String packaging) {
        this.packaging = packaging;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

/*
import java.util.Collection;
/*import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Medication", propOrder = {
    "name",
    "code",
    "isBrand",
    "manufacturer",
    "kind",
    "product",
    "_package"
})
@XmlRootElement(name = "Medication")
*


public class Medication
        extends Resource
        implements ToString
{

    protected org.hl7.fhir.model.String name;
    protected CodeableConcept code;
    protected Boolean isBrand;
    protected ResourceReference manufacturer;
    protected MedicationKind kind;
    protected MedicationProduct product;
    @XmlElement(name = "package")
    protected MedicationPackage _package;

    /**
     * Gets the value of the name property.
     *
     * @return
     *     possible object is
     *     {@link org.hl7.fhir.model.String }
     *

    public org.hl7.fhir.model.String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     *
     * @param value
     *     allowed object is
     *     {@link org.hl7.fhir.model.String }
     *

    public void setName(org.hl7.fhir.model.String value) {
        this.name = value;
    }

    /**
     * Gets the value of the code property.
     *
     * @return
     *     possible object is
     *     {@link CodeableConcept }
     *

    public CodeableConcept getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     *
     * @param value
     *     allowed object is
     *     {@link CodeableConcept }
     *
     *
    public void setCode(CodeableConcept value) {
        this.code = value;
    }

    /**
     * Gets the value of the isBrand property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     *
    public Boolean getIsBrand() {
        return isBrand;
    }

    /**
     * Sets the value of the isBrand property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     *
    public void setIsBrand(Boolean value) {
        this.isBrand = value;
    }

    /**
     * Gets the value of the manufacturer property.
     *
     * @return
     *     possible object is
     *     {@link ResourceReference }
     *
     *
    public ResourceReference getManufacturer() {
        return manufacturer;
    }

    /**
     * Sets the value of the manufacturer property.
     *
     * @param value
     *     allowed object is
     *     {@link ResourceReference }
     *
     *
    public void setManufacturer(ResourceReference value) {
        this.manufacturer = value;
    }

    /**
     * Gets the value of the kind property.
     *
     * @return
     *     possible object is
     *     {@link MedicationKind }
     *
     *
    public MedicationKind getKind() {
        return kind;
    }

    /**
     * Sets the value of the kind property.
     *
     * @param value
     *     allowed object is
     *     {@link MedicationKind }
     *
     *
    public void setKind(MedicationKind value) {
        this.kind = value;
    }

    /**
     * Gets the value of the product property.
     *
     * @return
     *     possible object is
     *     {@link MedicationProduct }
     *
     *
    public MedicationProduct getProduct() {
        return product;
    }

    /**
     * Sets the value of the product property.
     *
     * @param value
     *     allowed object is
     *     {@link MedicationProduct }
     *
     *
    public void setProduct(MedicationProduct value) {
        this.product = value;
    }

    /**
     * Gets the value of the package property.
     *
     * @return
     *     possible object is
     *     {@link MedicationPackage }
     *
     *
    public MedicationPackage getPackage() {
        return _package;
    }

    /**
     * Sets the value of the package property.
     *
     * @param value
     *     allowed object is
     *     {@link MedicationPackage }
     *
     *
    public void setPackage(MedicationPackage value) {
        this._package = value;
    }

    public java.lang.String toString() {
        final ToStringStrategy strategy = JAXBToStringStrategy.INSTANCE;
        final StringBuilder buffer = new StringBuilder();
        append(null, buffer, strategy);
        return buffer.toString();
    }

    public StringBuilder append(ObjectLocator locator, StringBuilder buffer, ToStringStrategy strategy) {
        strategy.appendStart(locator, this, buffer);
        appendFields(locator, buffer, strategy);
        strategy.appendEnd(locator, this, buffer);
        return buffer;
    }

    public StringBuilder appendFields(ObjectLocator locator, StringBuilder buffer, ToStringStrategy strategy) {
        super.appendFields(locator, buffer, strategy);
        {
            org.hl7.fhir.model.String theName;
            theName = this.getName();
            strategy.appendField(locator, this, "name", buffer, theName);
        }
        {
            CodeableConcept theCode;
            theCode = this.getCode();
            strategy.appendField(locator, this, "code", buffer, theCode);
        }
        {
            Boolean theIsBrand;
            theIsBrand = this.getIsBrand();
            strategy.appendField(locator, this, "isBrand", buffer, theIsBrand);
        }
        {
            ResourceReference theManufacturer;
            theManufacturer = this.getManufacturer();
            strategy.appendField(locator, this, "manufacturer", buffer, theManufacturer);
        }
        {
            MedicationKind theKind;
            theKind = this.getKind();
            strategy.appendField(locator, this, "kind", buffer, theKind);
        }
        {
            MedicationProduct theProduct;
            theProduct = this.getProduct();
            strategy.appendField(locator, this, "product", buffer, theProduct);
        }
        {
            MedicationPackage thePackage;
            thePackage = this.getPackage();
            strategy.appendField(locator, this, "_package", buffer, thePackage);
        }
        return buffer;
    }

    public Medication withName(org.hl7.fhir.model.String value) {
        setName(value);
        return this;
    }

    public Medication withCode(CodeableConcept value) {
        setCode(value);
        return this;
    }

    public Medication withIsBrand(Boolean value) {
        setIsBrand(value);
        return this;
    }

    public Medication withManufacturer(ResourceReference value) {
        setManufacturer(value);
        return this;
    }

    public Medication withKind(MedicationKind value) {
        setKind(value);
        return this;
    }

    public Medication withProduct(MedicationProduct value) {
        setProduct(value);
        return this;
    }

    public Medication withPackage(MedicationPackage value) {
        setPackage(value);
        return this;
    }

    @Override
    public Medication withLanguage(Code value) {
        setLanguage(value);
        return this;
    }

    @Override
    public Medication withText(Narrative value) {
        setText(value);
        return this;
    }

    @Override
    public Medication withContaineds(ResourceInline... values) {
        if (values!= null) {
            for (ResourceInline value: values) {
                getContaineds().add(value);
            }
        }
        return this;
    }

    @Override
    public Medication withContaineds(Collection<ResourceInline> values) {
        if (values!= null) {
            getContaineds().addAll(values);
        }
        return this;
    }

    @Override
    public Medication withModifierExtensions(Extension... values) {
        if (values!= null) {
            for (Extension value: values) {
                getModifierExtensions().add(value);
            }
        }
        return this;
    }

    @Override
    public Medication withModifierExtensions(Collection<Extension> values) {
        if (values!= null) {
            getModifierExtensions().addAll(values);
        }
        return this;
    }

    @Override
    public Medication withExtensions(Extension... values) {
        if (values!= null) {
            for (Extension value: values) {
                getExtensions().add(value);
            }
        }
        return this;
    }

    @Override
    public Medication withExtensions(Collection<Extension> values) {
        if (values!= null) {
            getExtensions().addAll(values);
        }
        return this;
    }

    @Override
    public Medication withId(java.lang.String value) {
        setId(value);
        return this;
    }

}


 */