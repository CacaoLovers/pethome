package ru.itis.pethome.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.pethome.dao.CityDao;
import ru.itis.pethome.dao.DistrictDao;
import ru.itis.pethome.dto.request.DistrictRequest;
import ru.itis.pethome.model.City;
import ru.itis.pethome.model.District;

import java.util.Optional;


@Service
@AllArgsConstructor
public class DistrictServiceImpl implements DistrictService {

    private final DistrictDao districtDao;
    private final CityDao cityDao;

    @Override
    public District createDistrict(District district) {
        return null;
    }

    @Override
    public District updateDistrict(District district) {
        return null;
    }

    @Override
    public Optional<District> getDistrictByName(DistrictRequest district) {
        return Optional.ofNullable(districtDao.getDistrictByNameAndCity(district.getName(), district.getCity()));
    }

    @Override
    public Optional<District> resolutionDistrict(DistrictRequest districtRequest) {
        Optional<District> district = getDistrictByName(districtRequest);

        if (district.isEmpty()){
            Optional<City> city = cityDao.findByName(districtRequest.getCity());

            if (city.isEmpty()){
                city = Optional.of(cityDao.save(City.builder()
                                .posX(districtRequest.getPosX())
                                .posY(districtRequest.getPosY())
                                .name(districtRequest.getCity())
                                .build()));
            }

            district = Optional.of(districtDao.save(District.builder()
                            .city(city.get())
                            .posX(districtRequest.getPosX())
                            .posY(districtRequest.getPosY())
                            .name(districtRequest.getName())
                            .build()));
        }

        return district;
    }

    @Override
    public void deleteDistrict(District district) {

    }

    @Override
    public City createCity(City city) {
        return null;
    }

    @Override
    public City updateCity(City city) {
        return null;
    }

    @Override
    public City deleteCity(City city) {
        return null;
    }

    @Override
    public Optional<City> findCityByName(String name) {
        return cityDao.findByName(name);
    }
}
