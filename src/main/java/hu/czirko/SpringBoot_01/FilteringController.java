package hu.czirko.SpringBoot_01;


import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import hu.czirko.SpringBoot_01.filtering.domain.SomeBean;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public MappingJacksonValue getSomeBean() {
        SomeBean bean = new SomeBean("value1", "value2");
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.serializeAllExcept("field1");

        FilterProvider filters = new SimpleFilterProvider()
                .addFilter("beanFilter", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(bean);
        mapping.setFilters(filters);

        return mapping;
    }

}
