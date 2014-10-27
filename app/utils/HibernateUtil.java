package utils;

import models.Livro;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by brg on 25/10/2014.
 */
public class HibernateUtil {

    static public Livro getFirstResult(TypedQuery<Livro> query) {
        List<Livro> livroList = query
                .setMaxResults(1)
                .getResultList();

        if (livroList.isEmpty()) {
            return null;
        }

        return livroList.get(0);
    }
}
