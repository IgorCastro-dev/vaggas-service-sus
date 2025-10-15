package org.sus.application.gateway;

import org.sus.domain.unidadeinfo.model.UnidadeInfo;

public interface BuscaUnidadeInfoGateway {
    UnidadeInfo execute(Long idUnidadeInfo);
}
