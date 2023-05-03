package th.co.prior.read_data_from_web.a.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import th.co.prior.read_data_from_web.a.Entity.MsEntity;
import th.co.prior.read_data_from_web.a.Entity.TransactionEntity;
import th.co.prior.read_data_from_web.a.Model.ExamTime;
import th.co.prior.read_data_from_web.a.Model.JsonFromWebModel;
import th.co.prior.read_data_from_web.a.Model.ResponseModel;
import th.co.prior.read_data_from_web.a.Model.TrModel;
import th.co.prior.read_data_from_web.a.Repository.MsRepositoryJPA;
import th.co.prior.read_data_from_web.a.Repository.TransactionRepositoryJPA;

import java.io.DataInput;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ReadDataService {

        private MsRepositoryJPA msRepositoryJPA;
        private TransactionRepositoryJPA transactionRepositoryJPA;

        public ReadDataService(MsRepositoryJPA msRepositoryJPA, TransactionRepositoryJPA transactionRepositoryJPA) {
                this.msRepositoryJPA = msRepositoryJPA;
                this.transactionRepositoryJPA = transactionRepositoryJPA;
        }

        public ResponseModel<List<?>> Example() throws IOException {

                ResponseModel<List<?>> result = new ResponseModel<>();

                List<TrModel> listAll = new ArrayList<>();

                RestTemplate restTemplate = new RestTemplate();

                HttpHeaders headers = new HttpHeaders();

                List<String> errors = new ArrayList<>();
                List<String> errorNames = new ArrayList<>();

                List<JsonFromWebModel> resList = new ArrayList<JsonFromWebModel>();

                ObjectMapper mapper = new ObjectMapper();

                List<TransactionEntity> listTransaction = new ArrayList<TransactionEntity>();

//                TransactionEntity transactionEntity = new TransactionEntity();

//                TrModel trModel = new TrModel();




                // TODO: 2/5/2023 AD Find list By urlMiddle

                List<MsEntity> listMs = this.msRepositoryJPA.findAll();

//                result.setData(listMs);

                // TODO: 2/5/2023 AD Create List

                // TODO: 2/5/2023 AD ForLOOP

                for (MsEntity msForLoop : listMs) {

                        String str = msForLoop.getSymbol();
                        str = str.replaceAll(" ", "");
//                        System.out.println(str);

//                        System.out.println(msForLoop.getSymbol().toString());

                        String urlFirst = "https://www.set.or.th/api/set/stock/";
                        // TODO: 2/5/2023 AD EDIT URL MIDDLE
//                        String urlMiddle = "AEC";
                        String urlMiddle = str;
                        String urlLast = "/historical-trading";
                        String langTh = "?lang=th";

                        String urlReal = urlFirst + urlMiddle + urlLast + langTh;

                        headers.set("authority", "www.set.or.th");
                        headers.set("accept", "application/json, text/plain, */*");
                        headers.set("accept-language", "th-TH,th;q=0.9");
                        headers.set("referer", "https://www.set.or.th/th/market/product/stock/quote/" + urlMiddle + urlLast);
                        headers.set("sec-ch-ua-mobile", "?0");
                        headers.set("sec-ch-ua-platform", "\"macOS\"");
                        headers.set("sec-fetch-dest", "empty");
                        headers.set("sec-fetch-mode", "cors");
                        headers.set("sec-fetch-site", "same-origin");
                        headers.set("cookie", "_gcl_au=1.1.659241747.1681894220; _fbp=fb.2.1681894220636.418911575; SET_COOKIE_POLICY=20220826121703; clientUuid=1a7c59e3-bcc3-489d-9421-a8c583623e61; visid_incap_2771851=NxyJ2r9sTT6nMimlii1Vxff5QGQAAAAAQUIPAAAAAACQrq8geT9RICjKPKjj+Ac2; nlbi_2046605=gJZvDd6xy1N7XugQz8Sz3wAAAADZNKi40LCgbRWHYXHMFHtn; _cbclose=1; _cbclose23453=1; _gid=GA1.3.229985567.1682493937; bull-popup-hidden=1; incap_ses_8025_2046605=39tee1LiymOQW3AhZIdeb8LZSWQAAAAAcyq0IY9U3nLX8uhpky86mQ==; incap_ses_8025_2771851=SFuAAc0SimtfQLEhZIdeb/tWSmQAAAAAHOgxnxUKXahgyl1KG4bY9g==; incap_ses_1006_2046605=7iZ4Z8nOnjC/PXTkDwr2DWlKS2QAAAAAeH0S3yEPGKr3i0n0F+xqzA==; visid_incap_2046605=2lzNV7tuTmWaxpxlMu3IH0u9QGQAAAAAQkIPAAAAAACA6OurARuRGjbXBATu3udfN7H14TOEhVaQ; my-quote=%5B%22ACE%22%2C%22TAKUNI%22%2C%22M%22%5D; api_call_counter=2; _uid23453=7C2187AB.11; display_expid={\"popup\":\"5AD93i4KR9-ZVNOhL9Vr2w-V2\"}; _ga=GA1.3.1736301633.1681894221; _ga_ET2H60H2CB=GS1.1.1682666604.13.0.1682666604.0.0.0; visit_time=10741");
                        headers.set("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/112.0.0.0 Safari/537.36");

                        HttpEntity<String> entity = new HttpEntity<>(null, headers);

                        try {
                                ResponseEntity<String> response = restTemplate.exchange(urlReal, HttpMethod.GET, entity, String.class);

                                JsonNode root = null;
                                root = mapper.readTree(response.getBody());


                                for (JsonNode node : root) {

                                        TrModel trModel = new TrModel();

                                        TransactionEntity transactionEntity = new TransactionEntity();


//                        JsonFromWebModel jsonFromWebModel = mapper.readValue((DataInput) node, JsonFromWebModel.class);
                                        String jsonString = node.toString();

                                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX");

                                        JsonFromWebModel jsonFromWebModel = mapper.readValue(jsonString, JsonFromWebModel.class);
                                        // TODO: 2/5/2023 AD Add to List entity
                                        resList.add(jsonFromWebModel);
                                        LocalDate transactionDate = LocalDate.parse(jsonFromWebModel.getDate(), formatter);

                                        trModel.setSymbol(jsonFromWebModel.getSymbol());
                                        trModel.setTransactionDate(transactionDate);
                                        trModel.setOpenPrice(jsonFromWebModel.getOpen());
                                        trModel.setMaxPrice(jsonFromWebModel.getHigh());
                                        trModel.setMinPrice(jsonFromWebModel.getLow());
                                        trModel.setClosePrice(jsonFromWebModel.getClose());
                                        trModel.setChangePrice(jsonFromWebModel.getChange());
                                        trModel.setChangeRatio(jsonFromWebModel.getPercentChange());
//                                        trModel.setNoOfStock();
                                        trModel.setVolume(jsonFromWebModel.getTotalVolume());
//                                        trModel.setReason();
//                                        trModel.setBatchId();


                                        transactionEntity.setSymbol(trModel.getSymbol());
                                        transactionEntity.setTransactionDate(trModel.getTransactionDate());
                                        transactionEntity.setOpenPrice(trModel.getOpenPrice());
                                        transactionEntity.setMaxPrice(trModel.getMaxPrice());
                                        transactionEntity.setMinPrice(trModel.getMinPrice());
                                        transactionEntity.setClosePrice(trModel.getClosePrice());
                                        transactionEntity.setChangePrice(trModel.getChangePrice());
                                        transactionEntity.setChangeRatio(trModel.getChangeRatio());
//                                        transactionEntity.setNoOfStock();
                                        transactionEntity.setVolume(trModel.getVolume());
//                                        transactionEntity.setReason();
//                                        transactionEntity.setBatchId();
//                                        this.transactionRepositoryJPA.save(transactionEntity);
                                        listAll.add(trModel);
                                        listTransaction.add(transactionEntity);
                                }
//                                listAll.add(trModel);

                        } catch (Exception e){

                                System.out.println(msForLoop.getSymbol().toString());
                                System.out.println(e.getMessage());
                                errors.add(e.getMessage());
                                errorNames.add(urlMiddle);

                        }
//                        listTransaction.add(transactionEntity);

                }
                // TODO: 2/5/2023 AD SAVE ALL  ENTITY



                System.out.println(listTransaction);
                result.setErrors(errors);
                result.setErrorNameStock(errorNames);
                result.setData(listAll);
                this.transactionRepositoryJPA.saveAll(listTransaction);

                return result;
        }

        public ResponseModel<?> newGame(ExamTime examTime) {
                ResponseModel<Integer> result = new ResponseModel<>();
                Integer fullRounds = 0;
                int startHour = Integer.parseInt(examTime.getStartTime().substring(0, 2));
                int startMinute = Integer.parseInt(examTime.getStartTime().substring(3));
                int finishHour = Integer.parseInt(examTime.getFinishTime().substring(0, 2));
                int finishMinute = Integer.parseInt(examTime.getFinishTime().substring(3));

                System.out.println(startHour);
                System.out.println(startMinute);
                System.out.println(finishHour);
                System.out.println(finishMinute);


                if ((startHour - 1) < finishHour){

                        Integer hourSum = (finishHour - startHour);
                        System.out.println(hourSum);
                Integer totalMinutes = hourSum * 60 + (startMinute-finishMinute);
                        System.out.println("total "+ totalMinutes);


                        if (totalMinutes < 0) {
                        // If finish time is earlier than start time, add a day's worth of minutes (1440)
                        totalMinutes += 1440;
                        System.out.println("total 1440 "+ totalMinutes);

                        }

                // Calculate the number of full rounds played during the game session
                fullRounds = totalMinutes / 15;

                System.out.println("fullRounds "+ fullRounds);


                System.out.println("startMinute "+startMinute);

                // Calculate the number of rounds that started at minute 00, 15, 30, and 45
                Integer rounds00 = startMinute < 15 ? 0 : 1;
                Integer rounds15 = startMinute < 30 ? 0 : 1;
                Integer rounds30 = startMinute < 45 ? 0 : 1;
                Integer rounds45 = startMinute < 60 ? 0 : 1;

                Integer qualifier = (rounds00 + rounds15 + rounds30 + rounds45);
                System.out.println("qualifier "+ qualifier);

//                 Subtract the rounds that started before the start time
                fullRounds = fullRounds - qualifier ;
                System.out.println("fullRounds2 "+ fullRounds);

                result.setData(fullRounds);

                String str = "susses";
                result.setDescription(str);
                return result;}
                else {
                        String str = "you have played overnight ";
                        result.setDescription(str);
                        result.setData(fullRounds);
                    return result;
                }

        }
}
