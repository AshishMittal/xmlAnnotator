package in.ac.iitb.XMLAnnotator;
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.09.04 at 08:23:19 PM BRT 
//




import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SnippetSet" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="snippet" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *                             &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="ans" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="quantity1" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="quantity2" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="TIMEX3" maxOccurs="unbounded" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;simpleContent>
 *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                                     &lt;attribute name="isRelevant" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                                     &lt;attribute name="isCorrect" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                                     &lt;attribute name="length" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                                     &lt;attribute name="offset" type="{http://www.w3.org/2001/XMLSchema}short" />
 *                                     &lt;attribute name="tid" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="value" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                   &lt;/extension>
 *                                 &lt;/simpleContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *                 &lt;attribute name="qid" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "snippetSet"
})
@XmlRootElement(name = "AllSnippetSet")
public class AllSnippetSet {

    @XmlElement(name = "SnippetSet")
    protected List<AllSnippetSet.SnippetSet> snippetSet;

    /**
     * Gets the value of the snippetSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the snippetSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSnippetSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AllSnippetSet.SnippetSet }
     * 
     * 
     */
    public List<AllSnippetSet.SnippetSet> getSnippetSet() {
        if (snippetSet == null) {
            snippetSet = new ArrayList<AllSnippetSet.SnippetSet>();
        }
        return this.snippetSet;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="snippet" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}byte"/>
     *                   &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="ans" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="quantity1" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="quantity2" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="TIMEX3" maxOccurs="unbounded" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;simpleContent>
     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                           &lt;attribute name="isRelevant" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *                           &lt;attribute name="isCorrect" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *                           &lt;attribute name="length" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *                           &lt;attribute name="offset" type="{http://www.w3.org/2001/XMLSchema}short" />
     *                           &lt;attribute name="tid" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="value" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                         &lt;/extension>
     *                       &lt;/simpleContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *       &lt;attribute name="qid" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "snippet"
    })
    public static class SnippetSet {

        protected List<AllSnippetSet.SnippetSet.Snippet> snippet;
        @XmlAttribute
        protected Byte qid;

        /**
         * Gets the value of the snippet property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the snippet property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getSnippet().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link AllSnippetSet.SnippetSet.Snippet }
         * 
         * 
         */
        public List<AllSnippetSet.SnippetSet.Snippet> getSnippet() {
            if (snippet == null) {
                snippet = new ArrayList<AllSnippetSet.SnippetSet.Snippet>();
            }
            return this.snippet;
        }

        /**
         * Gets the value of the qid property.
         * 
         * @return
         *     possible object is
         *     {@link Byte }
         *     
         */
        public Byte getQid() {
            return qid;
        }

        /**
         * Sets the value of the qid property.
         * 
         * @param value
         *     allowed object is
         *     {@link Byte }
         *     
         */
        public void setQid(Byte value) {
            this.qid = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}byte"/>
         *         &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="ans" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="quantity1" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="quantity2" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="TIMEX3" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;simpleContent>
         *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *                 &lt;attribute name="isRelevant" type="{http://www.w3.org/2001/XMLSchema}byte" />
         *                 &lt;attribute name="isCorrect" type="{http://www.w3.org/2001/XMLSchema}byte" />
         *                 &lt;attribute name="length" type="{http://www.w3.org/2001/XMLSchema}byte" />
         *                 &lt;attribute name="offset" type="{http://www.w3.org/2001/XMLSchema}short" />
         *                 &lt;attribute name="tid" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="value" type="{http://www.w3.org/2001/XMLSchema}string" />
         *               &lt;/extension>
         *             &lt;/simpleContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "id",
            "text",
            "ans",
            "quantity1",
            "quantity2",
            "timex3"
        })
        public static class Snippet {

            protected byte id;
            @XmlElement(required = true)
            protected String text;
            @XmlElement(required = true)
            protected String ans;
            @XmlElement(required = true)
            protected String quantity1;
            @XmlElement(required = true)
            protected String quantity2;
            @XmlElement(name = "TIMEX3")
            protected List<AllSnippetSet.SnippetSet.Snippet.TIMEX3> timex3;

            /**
             * Gets the value of the id property.
             * 
             */
            public byte getId() {
                return id;
            }

            /**
             * Sets the value of the id property.
             * 
             */
            public void setId(byte value) {
                this.id = value;
            }

            /**
             * Gets the value of the text property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getText() {
                return text;
            }

            /**
             * Sets the value of the text property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setText(String value) {
                this.text = value;
            }

            /**
             * Gets the value of the ans property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getAns() {
                return ans;
            }

            /**
             * Sets the value of the ans property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setAns(String value) {
                this.ans = value;
            }

            /**
             * Gets the value of the quantity1 property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getQuantity1() {
                return quantity1;
            }

            /**
             * Sets the value of the quantity1 property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setQuantity1(String value) {
                this.quantity1 = value;
            }

            /**
             * Gets the value of the quantity2 property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getQuantity2() {
                return quantity2;
            }

            /**
             * Sets the value of the quantity2 property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setQuantity2(String value) {
                this.quantity2 = value;
            }

            /**
             * Gets the value of the timex3 property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the timex3 property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getTIMEX3().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link AllSnippetSet.SnippetSet.Snippet.TIMEX3 }
             * 
             * 
             */
            public List<AllSnippetSet.SnippetSet.Snippet.TIMEX3> getTIMEX3() {
                if (timex3 == null) {
                    timex3 = new ArrayList<AllSnippetSet.SnippetSet.Snippet.TIMEX3>();
                }
                return this.timex3;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;simpleContent>
             *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
             *       &lt;attribute name="isRelevant" type="{http://www.w3.org/2001/XMLSchema}byte" />
             *       &lt;attribute name="isCorrect" type="{http://www.w3.org/2001/XMLSchema}byte" />
             *       &lt;attribute name="length" type="{http://www.w3.org/2001/XMLSchema}byte" />
             *       &lt;attribute name="offset" type="{http://www.w3.org/2001/XMLSchema}short" />
             *       &lt;attribute name="tid" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="value" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/extension>
             *   &lt;/simpleContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "value"
            })
            public static class TIMEX3 {

                @XmlValue
                protected String value;
                @XmlAttribute
                protected Byte isRelevant;
                @XmlAttribute
                protected Byte isCorrect;
                @XmlAttribute
                protected Byte length;
                @XmlAttribute
                protected Short offset;
                @XmlAttribute
                protected String tid;
                @XmlAttribute
                protected String type;
                @XmlAttribute(name = "value")
                protected String valueAttribute;

                /**
                 * Gets the value of the value property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getValue() {
                    return value;
                }

                /**
                 * Sets the value of the value property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setValue(String value) {
                    this.value = value;
                }

                /**
                 * Gets the value of the isRelevant property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Byte }
                 *     
                 */
                public Byte getIsRelevant() {
                    return isRelevant;
                }

                /**
                 * Sets the value of the isRelevant property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Byte }
                 *     
                 */
                public void setIsRelevant(Byte value) {
                    this.isRelevant = value;
                }

                /**
                 * Gets the value of the isCorrect property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Byte }
                 *     
                 */
                public Byte getIsCorrect() {
                    return isCorrect;
                }

                /**
                 * Sets the value of the isCorrect property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Byte }
                 *     
                 */
                public void setIsCorrect(Byte value) {
                    this.isCorrect = value;
                }

                /**
                 * Gets the value of the length property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Byte }
                 *     
                 */
                public Byte getLength() {
                    return length;
                }

                /**
                 * Sets the value of the length property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Byte }
                 *     
                 */
                public void setLength(Byte value) {
                    this.length = value;
                }

                /**
                 * Gets the value of the offset property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Short }
                 *     
                 */
                public Short getOffset() {
                    return offset;
                }

                /**
                 * Sets the value of the offset property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Short }
                 *     
                 */
                public void setOffset(Short value) {
                    this.offset = value;
                }

                /**
                 * Gets the value of the tid property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getTid() {
                    return tid;
                }

                /**
                 * Sets the value of the tid property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setTid(String value) {
                    this.tid = value;
                }

                /**
                 * Gets the value of the type property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getType() {
                    return type;
                }

                /**
                 * Sets the value of the type property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setType(String value) {
                    this.type = value;
                }

                /**
                 * Gets the value of the valueAttribute property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getValueAttribute() {
                    return valueAttribute;
                }

                /**
                 * Sets the value of the valueAttribute property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setValueAttribute(String value) {
                    this.valueAttribute = value;
                }

            }

        }

    }

}