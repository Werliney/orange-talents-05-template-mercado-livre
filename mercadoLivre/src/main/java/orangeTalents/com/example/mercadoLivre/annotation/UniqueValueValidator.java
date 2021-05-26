package orangeTalents.com.example.mercadoLivre.annotation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.Assert;

public class UniqueValueValidator implements ConstraintValidator<UniqueValue, Object> {

	private String domainAttribute;
	private Class<?> klass;
	@PersistenceContext
	private EntityManager manager;

	public void initialize(UniqueValue params) {
		this.domainAttribute = params.fieldName();
		this.klass = params.domainClass();
	}

	@Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        Query query = manager.createQuery("select 1 from  " + klass.getName() + " where " + domainAttribute + " =:value");
        query.setParameter("value", o);
        List<?> list  = query.getResultList();
        Assert.state(list.size() <=1, "Foi encontrado um  " +klass+" com o atributo "+domainAttribute+ " = " + o);
        return  list.isEmpty();
    }

}
