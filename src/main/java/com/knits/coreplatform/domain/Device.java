package com.knits.coreplatform.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * Entity that holds up Sensor data.\n@author Vassili Moskaljov\n@version 1.0
 */
@Entity
@Table(name = "device")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Device implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "serial_number")
    private String serialNumber;

    @Column(name = "manufacturer")
    private String manufacturer;

    @OneToOne
    @JoinColumn(unique = true)
    private Telemetry telemetry;

    @JsonIgnoreProperties(value = { "configurationData", "userData" }, allowSetters = true)
    @OneToOne
    @JoinColumn(unique = true)
    private DeviceConfiguration deviceConfiguration;

    @OneToOne
    @JoinColumn(unique = true)
    private Supplier supplier;

    @OneToOne
    @JoinColumn(unique = true)
    private DeviceModel deviceModel;

    @OneToMany(mappedBy = "device", cascade = CascadeType.PERSIST)
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "ruleConfigurations", "device" }, allowSetters = true)
    private Set<Rule> rules = new HashSet<>();

    @OneToMany(mappedBy = "device", cascade = CascadeType.PERSIST)
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "alertConfiguration", "device" }, allowSetters = true)
    private Set<AlertMessage> alertMessages = new HashSet<>();

    @OneToMany(mappedBy = "device", cascade = CascadeType.PERSIST)
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "device" }, allowSetters = true)
    private Set<Metadata> metaData = new HashSet<>();

    @OneToMany(mappedBy = "device", cascade = CascadeType.PERSIST)
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "device" }, allowSetters = true)
    private Set<Status> statuses = new HashSet<>();

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JsonIgnoreProperties(value = { "location", "devices", "states", "thingCategory", "application" }, allowSetters = true)
    private Thing thing;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JsonIgnoreProperties(value = { "devices" }, allowSetters = true)
    private DeviceGroup deviceGroup;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Device id(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public Device name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSerialNumber() {
        return this.serialNumber;
    }

    public Device serialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
        return this;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public Device manufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
        return this;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Telemetry getTelemetry() {
        return this.telemetry;
    }

    public Device telemetry(Telemetry telemetry) {
        this.setTelemetry(telemetry);
        return this;
    }

    public void setTelemetry(Telemetry telemetry) {
        this.telemetry = telemetry;
    }

    public DeviceConfiguration getDeviceConfiguration() {
        return this.deviceConfiguration;
    }

    public Device deviceConfiguration(DeviceConfiguration deviceConfiguration) {
        this.setDeviceConfiguration(deviceConfiguration);
        return this;
    }

    public void setDeviceConfiguration(DeviceConfiguration deviceConfiguration) {
        this.deviceConfiguration = deviceConfiguration;
    }

    public Supplier getSupplier() {
        return this.supplier;
    }

    public Device supplier(Supplier supplier) {
        this.setSupplier(supplier);
        return this;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public DeviceModel getDeviceModel() {
        return this.deviceModel;
    }

    public Device deviceModel(DeviceModel deviceModel) {
        this.setDeviceModel(deviceModel);
        return this;
    }

    public void setDeviceModel(DeviceModel deviceModel) {
        this.deviceModel = deviceModel;
    }

    public Set<Rule> getRules() {
        return this.rules;
    }

    public Device rules(Set<Rule> rules) {
        this.setRules(rules);
        return this;
    }

    public Device addRule(Rule rule) {
        this.rules.add(rule);
        rule.setDevice(this);
        return this;
    }

    public Device removeRule(Rule rule) {
        this.rules.remove(rule);
        rule.setDevice(null);
        return this;
    }

    public void setRules(Set<Rule> rules) {
        if (this.rules != null) {
            this.rules.forEach(i -> i.setDevice(null));
        }
        if (rules != null) {
            rules.forEach(i -> i.setDevice(this));
        }
        this.rules = rules;
    }

    public Set<AlertMessage> getAlertMessages() {
        return this.alertMessages;
    }

    public Device alertMessages(Set<AlertMessage> alertMessages) {
        this.setAlertMessages(alertMessages);
        return this;
    }

    public Device addAlertMessage(AlertMessage alertMessage) {
        this.alertMessages.add(alertMessage);
        alertMessage.setDevice(this);
        return this;
    }

    public Device removeAlertMessage(AlertMessage alertMessage) {
        this.alertMessages.remove(alertMessage);
        alertMessage.setDevice(null);
        return this;
    }

    public void setAlertMessages(Set<AlertMessage> alertMessages) {
        if (this.alertMessages != null) {
            this.alertMessages.forEach(i -> i.setDevice(null));
        }
        if (alertMessages != null) {
            alertMessages.forEach(i -> i.setDevice(this));
        }
        this.alertMessages = alertMessages;
    }

    public Set<Metadata> getMetaData() {
        return this.metaData;
    }

    public Device metaData(Set<Metadata> metadata) {
        this.setMetaData(metadata);
        return this;
    }

    public Device addMetaData(Metadata metadata) {
        this.metaData.add(metadata);
        metadata.setDevice(this);
        return this;
    }

    public Device removeMetaData(Metadata metadata) {
        this.metaData.remove(metadata);
        metadata.setDevice(null);
        return this;
    }

    public void setMetaData(Set<Metadata> metadata) {
        if (this.metaData != null) {
            this.metaData.forEach(i -> i.setDevice(null));
        }
        if (metadata != null) {
            metadata.forEach(i -> i.setDevice(this));
        }
        this.metaData = metadata;
    }

    public Set<Status> getStatuses() {
        return this.statuses;
    }

    public Device statuses(Set<Status> statuses) {
        this.setStatuses(statuses);
        return this;
    }

    public Device addStatus(Status status) {
        this.statuses.add(status);
        status.setDevice(this);
        return this;
    }

    public Device removeStatus(Status status) {
        this.statuses.remove(status);
        status.setDevice(null);
        return this;
    }

    public void setStatuses(Set<Status> statuses) {
        if (this.statuses != null) {
            this.statuses.forEach(i -> i.setDevice(null));
        }
        if (statuses != null) {
            statuses.forEach(i -> i.setDevice(this));
        }
        this.statuses = statuses;
    }

    public Thing getThing() {
        return this.thing;
    }

    public Device thing(Thing thing) {
        this.setThing(thing);
        return this;
    }

    public void setThing(Thing thing) {
        this.thing = thing;
    }

    public DeviceGroup getDeviceGroup() {
        return this.deviceGroup;
    }

    public Device deviceGroup(DeviceGroup deviceGroup) {
        this.setDeviceGroup(deviceGroup);
        return this;
    }

    public void setDeviceGroup(DeviceGroup deviceGroup) {
        this.deviceGroup = deviceGroup;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Device)) {
            return false;
        }
        return id != null && id.equals(((Device) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Device{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", serialNumber='" + getSerialNumber() + "'" +
            ", manufacturer='" + getManufacturer() + "'" +
            "}";
    }
}
