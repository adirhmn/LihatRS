package com.adi.lihatrs;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Model {
    private List<Provinces> provinces;
    private List<Cities> cities;
    private List<Hospitals> hospitals;
    private MapHospital mapHospital;
    private Data data;

    public List<Provinces> getProvinces() {
        return provinces;
    }

    public void setProvinces(List<Provinces> provinces) {
        this.provinces = provinces;
    }

    public class Provinces{
        private String id;
        private String name;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public List<Cities> getCities() {
        return cities;
    }

    public void setCities(List<Cities> cities) {
        this.cities = cities;
    }

    public class Cities{
        private String id;
        private String name;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public List<Hospitals> getHospitals() {
        return hospitals;
    }

    public void setHospitals(List<Hospitals> hospitals) {
        this.hospitals = hospitals;
    }

    public class Hospitals{
        private String id;
        private String name;
        private String address;
        private String phone;
        private List<AvailableBeds> available_beds;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public List<AvailableBeds> getAvailable_beds() {
            return available_beds;
        }

        public void setAvailable_beds(List<AvailableBeds> available_beds) {
            this.available_beds = available_beds;
        }

        public class AvailableBeds{
            private int available;
            private String bed_class;
            private String room_name;
            private String info;

            public int getAvailable() {
                return available;
            }

            public void setAvailable(int available) {
                this.available = available;
            }

            public String getBed_class() {
                return bed_class;
            }

            public void setBed_class(String bed_class) {
                this.bed_class = bed_class;
            }

            public String getRoom_name() {
                return room_name;
            }

            public void setRoom_name(String room_name) {
                this.room_name = room_name;
            }

            public String getInfo() {
                return info;
            }

            public void setInfo(String info) {
                this.info = info;
            }
        }
    }
    public class MapHospital{
        private Data data;
        private int status;

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public Data getData() {
            return data;
        }

        public void setData(Data data) {
            this.data = data;
        }

        public class Data{
            private String id;
            private String name;
            private String address;
            private String lat;

            @SerializedName("long")
            private String lon;

            private String gmaps;

            public String getLon() {
                return lon;
            }

            public void setLon(String lon) {
                this.lon = lon;
            }
            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getLat() {
                return lat;
            }

            public void setLat(String lat) {
                this.lat = lat;
            }

            public String getGmaps() {
                return gmaps;
            }

            public void setGmaps(String gmaps) {
                this.gmaps = gmaps;
            }
        }
    }

    public MapHospital getMapHospital() {
        return mapHospital;
    }

    public void setMapHospital(MapHospital mapHospital) {
        this.mapHospital = mapHospital;
    }

    public class Data{
        private String id;
        private String name;
        private String address;
        private String lat;

        @SerializedName("long")
        private String lon;

        private String gmaps;

        public String getLon() {
            return lon;
        }

        public void setLon(String lon) {
            this.lon = lon;
        }
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public String getGmaps() {
            return gmaps;
        }

        public void setGmaps(String gmaps) {
            this.gmaps = gmaps;
        }
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
