package ru.itis.pethome.service;

import ru.itis.pethome.dto.request.DistrictRequest;
import ru.itis.pethome.model.City;
import ru.itis.pethome.model.District;

import java.util.Optional;

public interface DistrictService {

    District createDistrict(District district);

    District updateDistrict(District district);


    Optional<District> getDistrictByName(DistrictRequest district);

    Optional<District> resolutionDistrict(DistrictRequest districtRequest);

    void deleteDistrict(District district);

    City createCity(City city);

    City updateCity(City city);

    City deleteCity(City city);

    Optional<City> findCityByName(String name);

}
