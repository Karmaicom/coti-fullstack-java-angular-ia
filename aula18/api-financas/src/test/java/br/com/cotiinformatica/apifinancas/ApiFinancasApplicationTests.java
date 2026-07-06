package br.com.cotiinformatica.apifinancas;


import br.com.cotiinformatica.apifinancas.dtos.CategoriaRequestDTO;
import br.com.cotiinformatica.apifinancas.dtos.CategoriaResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ApiFinancasApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("Deve criar uma nova categoria com sucesso!")
    public void criarCategoriaTest() throws Exception {

        // ARRANGE (Preparar os dados para teste)
        var request = new CategoriaRequestDTO("Categoria teste");

        // ACT (Executar endpoint POST /api/v1/categorias/criar)
        var result = mockMvc.perform(
                post("/api/v1/categorias/criar") //requisição POST para a API
                .contentType("application/json") //formato dos dados (JSON)
                .content(objectMapper.writeValueAsString(request))) //dados enviados
                .andExpect(status().isCreated()) //esperando retorno HTTP 201
                .andReturn(); //capturando os dados da resposta do endpoint

        // ASSERT (verificar o resultado do teste)
        var jsonContent = result.getResponse().getContentAsString();
        var response = objectMapper.readValue(jsonContent, CategoriaResponseDTO.class);

        //ASSERT: O id da categoria deve vir preenchido com um UUID aleatório
        assertNotNull(response.id());

        //ASSERT: O nome da categoria deve ser igual ao enviado na requisição
        assertEquals(request.nome(), response.nome());
    }

}
