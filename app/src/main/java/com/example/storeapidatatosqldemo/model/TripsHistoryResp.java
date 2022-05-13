package com.example.storeapidatatosqldemo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TripsHistoryResp
{
    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("startLocation")
    @Expose
    private Object startLocation;
    @SerializedName("endLocation")
    @Expose
    private Object endLocation;
    @SerializedName("startTime")
    @Expose
    private String startTime;
    @SerializedName("endTime")
    @Expose
    private String endTime;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("rating")
    @Expose
    private Object rating;
    @SerializedName("createdAt")
    @Expose
    private String createdAt;
    @SerializedName("createdByparty")
    @Expose
    private CreatedBypartyResp createdByparty;
    @SerializedName("provider")
    @Expose
    private com.example.storeapidatatosqldemo.model.ProviderResp provider;
    @SerializedName("driver")
    @Expose
    private DriverResp driver;
    @SerializedName("passenger")
    @Expose
    private com.example.storeapidatatosqldemo.model.PassengerResp passenger;
    @SerializedName("reservationStatus")
    @Expose
    private String reservationStatus;
    @SerializedName("bookingChannel")
    @Expose
    private String bookingChannel;
    @SerializedName("serviceType")
    @Expose
    private String serviceType;
    @SerializedName("acceptedByDriverAt")
    @Expose
    private String acceptedByDriverAt;
    @SerializedName("reachedLocationAt")
    @Expose
    private Object reachedLocationAt;
    @SerializedName("vehicleId")
    @Expose
    private Integer vehicleId;
    @SerializedName("reservationId")
    @Expose
    private Integer reservationId;
    @SerializedName("invoiceId")
    @Expose
    private Object invoiceId;
    @SerializedName("paymentId")
    @Expose
    private Object paymentId;
    @SerializedName("startLocationCity")
    @Expose
    private String startLocationCity;
    @SerializedName("endlocationCity")
    @Expose
    private String endlocationCity;
    @SerializedName("scheduleId")
    @Expose
    private Long scheduleId;
    @SerializedName("vehcileNo")
    @Expose
    private String vehcileNo;
    @SerializedName("estimatedPrice")
    @Expose
    private Double estimatedPrice;
    @SerializedName("driverImageUrl")
    @Expose
    private String driverImageUrl;
    @SerializedName("otp")
    @Expose
    private String otp;

    public TripsHistoryResp(Long id, String startTime, String endTime, String status, String serviceType, String startLocationCity, String endlocationCity, double estimatedPrice) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
        this.serviceType = serviceType;
        this.startLocationCity = startLocationCity;
        this.endlocationCity = endlocationCity;
        this.estimatedPrice = estimatedPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Object getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(Object startLocation) {
        this.startLocation = startLocation;
    }

    public Object getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(Object endLocation) {
        this.endLocation = endLocation;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getRating() {
        return rating;
    }

    public void setRating(Object rating) {
        this.rating = rating;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public CreatedBypartyResp getCreatedByparty() {
        return createdByparty;
    }

    public void setCreatedByparty(CreatedBypartyResp createdByparty) {
        this.createdByparty = createdByparty;
    }

    public com.example.storeapidatatosqldemo.model.ProviderResp getProvider() {
        return provider;
    }

    public void setProvider(com.example.storeapidatatosqldemo.model.ProviderResp provider) {
        this.provider = provider;
    }

    public DriverResp getDriver() {
        return driver;
    }

    public void setDriver(DriverResp driver) {
        this.driver = driver;
    }

    public com.example.storeapidatatosqldemo.model.PassengerResp getPassenger() {
        return passenger;
    }

    public void setPassenger(com.example.storeapidatatosqldemo.model.PassengerResp passenger) {
        this.passenger = passenger;
    }

    public String getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(String reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    public String getBookingChannel() {
        return bookingChannel;
    }

    public void setBookingChannel(String bookingChannel) {
        this.bookingChannel = bookingChannel;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getAcceptedByDriverAt() {
        return acceptedByDriverAt;
    }

    public void setAcceptedByDriverAt(String acceptedByDriverAt) {
        this.acceptedByDriverAt = acceptedByDriverAt;
    }

    public Object getReachedLocationAt() {
        return reachedLocationAt;
    }

    public void setReachedLocationAt(Object reachedLocationAt) {
        this.reachedLocationAt = reachedLocationAt;
    }

    public Integer getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Integer getReservationId() {
        return reservationId;
    }

    public void setReservationId(Integer reservationId) {
        this.reservationId = reservationId;
    }

    public Object getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Object invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Object getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Object paymentId) {
        this.paymentId = paymentId;
    }

    public String getStartLocationCity() {
        return startLocationCity;
    }

    public void setStartLocationCity(String startLocationCity) {
        this.startLocationCity = startLocationCity;
    }

    public String getEndlocationCity() {
        return endlocationCity;
    }

    public void setEndlocationCity(String endlocationCity) {
        this.endlocationCity = endlocationCity;
    }

    public Long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Long scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getVehcileNo() {
        return vehcileNo;
    }

    public void setVehcileNo(String vehcileNo) {
        this.vehcileNo = vehcileNo;
    }

    public Double getEstimatedPrice() {
        return estimatedPrice;
    }

    public void setEstimatedPrice(Double estimatedPrice) {
        this.estimatedPrice = estimatedPrice;
    }

    public String getDriverImageUrl() {
        return driverImageUrl;
    }

    public void setDriverImageUrl(String driverImageUrl) {
        this.driverImageUrl = driverImageUrl;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    @Override
    public String toString() {
        return "TripsHistoryResp{" +
                "id=" + id +
                ", startLocation=" + startLocation +
                ", endLocation=" + endLocation +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", status='" + status + '\'' +
                ", rating=" + rating +
                ", createdAt='" + createdAt + '\'' +
                ", createdByparty=" + createdByparty +
                ", provider=" + provider +
                ", driver=" + driver +
                ", passenger=" + passenger +
                ", reservationStatus='" + reservationStatus + '\'' +
                ", bookingChannel='" + bookingChannel + '\'' +
                ", serviceType='" + serviceType + '\'' +
                ", acceptedByDriverAt='" + acceptedByDriverAt + '\'' +
                ", reachedLocationAt=" + reachedLocationAt +
                ", vehicleId=" + vehicleId +
                ", reservationId=" + reservationId +
                ", invoiceId=" + invoiceId +
                ", paymentId=" + paymentId +
                ", startLocationCity='" + startLocationCity + '\'' +
                ", endlocationCity='" + endlocationCity + '\'' +
                ", scheduleId=" + scheduleId +
                ", vehcileNo='" + vehcileNo + '\'' +
                ", estimatedPrice=" + estimatedPrice +
                ", driverImageUrl='" + driverImageUrl + '\'' +
                ", otp='" + otp + '\'' +
                '}';
    }
}
