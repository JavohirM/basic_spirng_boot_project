package uz.writer.service;

import com.google.common.base.Strings;
import com.univocity.parsers.csv.CsvWriter;
import com.univocity.parsers.csv.CsvWriterSettings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import uz.writer.dao.dto.PortLd10Model;
import uz.writer.dao.dto.Report;
import uz.writer.dao.dto.ResultDto;
import uz.writer.dao.title.TitleCSV;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@Service
public class FileCreatorService {


    private final DatabaseService sqlCaller;

    private final static String[] titles = TitleCSV.PORT_LD_10_TITLES;

    private static final int time = 10_000;

    private final Logger log = LoggerFactory.getLogger(FileCreatorService.class);

    public FileCreatorService(DatabaseService sqlCaller) {
        this.sqlCaller = sqlCaller;
    }

    public Flux<PortLd10Model> getAllDetails(String date) {
        return sqlCaller.getAll(date);
    }

    public Flux<PortLd10Model> getAllWithBranchAndDate(String date, String branch) {
        return sqlCaller.getByBranch(date, branch);
    }


    public ResultDto getByAll(String date) {
        List<PortLd10Model> block = getAllDetails(date).collectList().block();

        List<Object[]> result = new ArrayList<>();
//        List<PortLd10Model> get = new ArrayList<>();
        ResultDto resultDto = new ResultDto();
        result.add(titles);
//        sqlCaller.getAll(date).subscribe(get::add);

        try {
            if (block != null) {
                block.forEach(p -> {
                    Object[] data = mapper.apply(p);
                    result.add(data);
                });
            }
        } catch (Exception e) {
            log.error("Data size:  {} | Error Message: {} | Trace: {}", result.size(), e.getMessage(), e.getStackTrace());
            resultDto.setCode("04000");
            resultDto.setMessage(e.getMessage());
            return resultDto;
        }
        return createFile(result);
    }

    public ResultDto getByBranch(String date, String branch) {
        List<Object[]> result = new ArrayList<>();
        List<PortLd10Model> get = new ArrayList<>();
        ResultDto resultDto = new ResultDto();
        result.add(titles);
        sqlCaller.getByBranch(date, branch).subscribe(get::add);

        try {
            Thread.sleep(time);
            get.forEach(p -> {
                Object[] data = mapper.apply(p);
                result.add(data);
            });
        } catch (Exception e) {
            log.error("Data size:  {} | Error Message: {} | Trace: {}", result.size(), e.getMessage(), e.getStackTrace());
            resultDto.setCode("04000");
            resultDto.setMessage(e.getMessage());
            return resultDto;
        }
        return createFile(result);
    }


    private ResultDto createFile(List<Object[]> data) {
        ResultDto resultDto = new ResultDto();
        try {
            CsvWriterSettings settings = new CsvWriterSettings();
            settings.setNullValue("");
            settings.setEmptyValue(" ");
            settings.setQuoteEscapingEnabled(true);
            settings.setQuoteAllFields(true);
            CsvWriter writer = new CsvWriter(new File("./file/report.csv"), "UTF-8", settings);
            writer.writeRowsAndClose(data);
            resultDto.setCode("05000");
            resultDto.setMessage("Created File");

            return resultDto;
        } catch (Exception e) {
            log.error("Data size:  {} | Error Message: {} | Trace: {}", data.size(), e.getCause(), e.getStackTrace());
            resultDto.setCode("04000");
            resultDto.setMessage(e.getMessage());
            return resultDto;
        }
    }


    private final Function<Report, Object[]> map = dto ->
            new Object[]{dto.getClientDoc(), dto.getClientPhone(), dto.getUserId(), dto.getBanId(), dto.getCode()};

    private final Function<Report, Report> s = dto -> {
        if (Strings.isNullOrEmpty(dto.getCode())) dto.setCode(" ");

        return dto;
    };

    private final Function<PortLd10Model, Object[]> mapper = dto ->
            new Object[]{
                    dto.getLdId(),
                    dto.getSbor(),
                    dto.getStatusName(),
                    dto.getNClaim(),
                    dto.getNClaim(),
                    dto.getReqNCode(),
                    dto.getAccount(),
                    dto.getIdsRegion(),
                    dto.getBranchNam(),
                    dto.getClientName(),
                    dto.getTipCl(),
                    dto.getTipClKod(),
                    dto.getUseBranch(),
                    dto.getTaxRegistr(),
                    dto.getBirthday(),
                    dto.getDistr(),
                    dto.getDistrName(),
                    dto.getNActNumNew(),
                    dto.getNActDateNew(),
                    dto.getCrcNum(),
                    dto.getCrcDate(),
                    dto.getPNum1(),
                    dto.getPDate(),
                    dto.getLdAmount(),
                    dto.getLdAmountEqv(),
                    dto.getNameguarr(),
                    dto.getDistSum(),
                    dto.getDistSumEqv(),
                    dto.getDistSumY(),
                    dto.getDistSumYEqv(),
                    dto.getNalBez(),
                    dto.getDatDelay(),
                    dto.getKolDeb2(),
                    dto.getSoogu(),
                    dto.getSummKr(),
                    dto.getSummOstZ(),
                    dto.getSummOstZe(),
                    dto.getAccOver(),
                    dto.getSummOstprZ(),
                    dto.getSummOstprZe(),
                    dto.getDateOldPr(),
                    dto.getDateLast3(),
                    dto.getIdsVal(),
                    dto.getSredName(),
                    dto.getSredId(),
                    dto.getNameFin(),
                    dto.getAbrSource(),
                    dto.getTarget(),
                    dto.getKolWork(),
                    dto.getShifrId(),
                    dto.getKodOtr(),
                    dto.getCodeSectorOld(),
                    dto.getCodeSector(),
                    dto.getCodeSectorName(),
                    dto.getRate(),
                    dto.getRateDog(),
                    dto.getDateToCr(),
                    dto.getDatLastDb(),
                    dto.getSumLastDb(),
                    dto.getDateClose(),
                    dto.getPogTek(),
                    dto.getPogTek1(),
                    dto.getPogTek2(),
                    dto.getGuarName(),
                    dto.getGuarId(),
                    dto.getMaxGuarId(),
                    dto.getSumguarr(),
                    dto.getSumproc(),
                    dto.getSumprocEqv(),
                    dto.getDateLastPr(),
                    dto.getSumnachpr(),
                    dto.getSumnachprEqv(),
                    dto.getDatL31(),
                    dto.getSummNachPr(),
                    dto.getSummNachPrS(),
                    dto.getAllPog(),
                    dto.getSummprodpr(),
                    dto.getSummprodprEqv(),
                    dto.getSummprop(),
                    dto.getSummpropEqv(),
                    dto.getDateFinPr(),
                    dto.getOst17(),
                    dto.getOst46(),
                    dto.getOst44(),
                    dto.getOst48(),
                    dto.getSumOst7173(),
                    dto.getSumOst7173E(),
                    dto.getDatOld7173(),
                    dto.getPNum(),
                    dto.getDatePost(),
                    dto.getKlassName(),
                    dto.getKlassKod(),
                    dto.getSummrez(),
                    dto.getSummrezEqv(),
                    dto.getFio(),
                    dto.getSsLdTypeId(),
                    dto.getSsLdTypeName(),
                    dto.getSsCreditId(),
                    dto.getSsCreditName(),
                    dto.getSCreditKod(),
                    dto.getSCreditName(),
                    dto.getSueDate(),
                    dto.getDecreeDate(),
                    dto.getCommentary(),
                    dto.getLawOrganization(),
                    dto.getSignOfDesigion(),
                    dto.getFullName(),
                    dto.getKur(),
                    dto.getTermType(),
                    dto.getEmpCount(),
                    dto.getKodInt(),
                    dto.getEnterpTypeK(),
                    dto.getEnterpTypeN(),
                    dto.getMinLdGr(),
                    dto.getNameActu(),
                    dto.getDateActuClose(),
                    dto.getFinCred(),
                    dto.getSumm16405(),
                    dto.getSumm16413(),
                    dto.getSumm16413Pr(),
                    dto.getRateUpr(),
                    dto.getCalcMethod(),
                    dto.getReapyDat(),
                    dto.getRepaySum(),
                    dto.getDateCancel(),
                    dto.getSummCancel(),
                    dto.getRateProc(),
                    dto.getBeginRate(),
                    dto.getKodFin(),
                    dto.getSummLast3(),
                    dto.getAccV(),
                    dto.getSShifrNam(),
                    dto.getProdName(),
                    dto.getSBranchNam(),
                    dto.getAmGuar20(),
                    dto.getAmGuar21(),
                    dto.getAmGuar22(),
                    dto.getAmGuar23(),
                    dto.getAmGuar24(),
                    dto.getAmGuar25(),
                    dto.getAmGuar26(),
                    dto.getAmGuar27(),
                    dto.getAmGuar28(),
                    dto.getAmGuar29(),
                    dto.getAmGuar30(),
                    dto.getAmGuar31(),
                    dto.getAmGuar32(),
                    dto.getAmGuar33(),
                    dto.getAmGuar34(),
                    dto.getAmGuar35(),
                    dto.getAmGuar36(),
                    dto.getAmGuar37(),
                    dto.getAmGuar38(),
                    dto.getAmGuar39(),
                    dto.getAmGuar40(),
                    dto.getAmGuar41(),
                    dto.getAmGuar42(),
                    dto.getAmGuar50(),
                    dto.getAmGuar51(),
                    dto.getAmGuar60(),
                    dto.getAmGuar61(),
                    dto.getDop1001(),
                    dto.getDop1002(),
                    dto.getDop1003(),
                    dto.getDop1004(),
                    dto.getDop1005(),
                    dto.getDop1006(),
                    dto.getDop1007(),
                    dto.getDop1008(),
                    dto.getDop1009(),
                    dto.getDop1010(),
                    dto.getDop1011(),
                    dto.getDop1012(),
                    dto.getDop1013(),
                    dto.getDop1014(),
                    dto.getDop1015(),
                    dto.getDop1016(),
                    dto.getDop1017(),
                    dto.getDop1018(),
                    dto.getDop1019(),
                    dto.getDop1020(),
                    dto.getSummLayPr(),
                    dto.getSummLayPrEqv(),
                    dto.getCodeMort(),
                    dto.getAcompName(),
                    dto.getEvalReportNum(),
                    dto.getIdSsSubsidiary(),
                    dto.getSubsidiary(),
                    dto.getSummNachPrNm(),
                    dto.getSummNachPrSNm(),
                    dto.getCodeBal(),
                    dto.getDatDelay31(),
                    dto.getIdClient(),
                    dto.getAcc09(),
                    dto.getAcc09E(),
                    dto.getAccond9(),
                    dto.getLastDbR(),
                    dto.getAhtunN(),
                    dto.getLoanId(),
                    dto.getLoanName(),
                    dto.getAccHoli(),
                    dto.getHoliSym(),
                    dto.getAhtunN1(),
                    dto.getAhtunN2(),
                    dto.getPassportSn(),

            };


    private final Function<PortLd10Model, PortLd10Model> isNullOrEmpty = dto ->
    {
        if (Strings.isNullOrEmpty(dto.getLdId().toString())) dto.setLdId(Long.valueOf(" "));
        if (Strings.isNullOrEmpty(dto.getSbor())) dto.setSbor(" ");
        if (Strings.isNullOrEmpty(dto.getStatusName())) dto.setStatusName(" ");
        if (Strings.isNullOrEmpty(dto.getNClaim())) dto.setNClaim(" ");
        if (Strings.isNullOrEmpty(dto.getNClaim())) dto.setNClaim(" ");
        if (Strings.isNullOrEmpty(dto.getReqNCode())) dto.setReqNCode(" ");
        if (Strings.isNullOrEmpty(dto.getAccount())) dto.setAccount(" ");
        if (Strings.isNullOrEmpty(dto.getIdsRegion())) dto.setIdsRegion(" ");
        if (Strings.isNullOrEmpty(dto.getBranchNam())) dto.setBranchNam(" ");
        if (Strings.isNullOrEmpty(dto.getClientName())) dto.setClientName(" ");
        if (Strings.isNullOrEmpty(dto.getTipCl())) dto.setTipCl(" ");
        if (Strings.isNullOrEmpty(dto.getTipClKod())) dto.setTipClKod(" ");
        if (Strings.isNullOrEmpty(dto.getUseBranch())) dto.setUseBranch(" ");
        if (Strings.isNullOrEmpty(dto.getTaxRegistr())) dto.setTaxRegistr(" ");
        if (Strings.isNullOrEmpty(dto.getBirthday())) dto.setBirthday(" ");
        if (Strings.isNullOrEmpty(dto.getDistr())) dto.setDistr(" ");
        if (Strings.isNullOrEmpty(dto.getDistrName())) dto.setDistrName(" ");
        if (Strings.isNullOrEmpty(dto.getNActNumNew())) dto.setNActNumNew(" ");
        if (Strings.isNullOrEmpty(dto.getNActDateNew())) dto.setNActDateNew(" ");
        if (Strings.isNullOrEmpty(dto.getCrcNum())) dto.setCrcNum(" ");
        if (Strings.isNullOrEmpty(dto.getCrcDate())) dto.setCrcDate(" ");
        if (Strings.isNullOrEmpty(dto.getPNum1())) dto.setPNum1(" ");
        if (Strings.isNullOrEmpty(dto.getPDate())) dto.setPDate(" ");
        if (Strings.isNullOrEmpty(dto.getLdAmount().toString())) dto.setLdAmount(Long.valueOf(" "));
        if (Strings.isNullOrEmpty(dto.getLdAmountEqv().toString())) dto.setLdAmountEqv(Long.valueOf(" "));
        if (Strings.isNullOrEmpty(dto.getNameguarr())) dto.setNameguarr(" ");
        if (Strings.isNullOrEmpty(dto.getDistSum().toString())) dto.setDistSum(Long.valueOf(" "));
        if (Strings.isNullOrEmpty(dto.getDistSumEqv().toString())) dto.setDistSumEqv(Long.valueOf(" "));
        if (Strings.isNullOrEmpty(dto.getDistSumY())) dto.setDistSumY(" ");
        if (Strings.isNullOrEmpty(dto.getDistSumYEqv())) dto.setDistSumYEqv(" ");
        if (Strings.isNullOrEmpty(dto.getNalBez().toString())) dto.setNalBez(Long.valueOf(" "));
        if (Strings.isNullOrEmpty(dto.getDatDelay())) dto.setDatDelay(" ");
        if (Strings.isNullOrEmpty(dto.getKolDeb2().toString())) dto.setKolDeb2(Long.valueOf(" "));
        if (Strings.isNullOrEmpty(dto.getSoogu())) dto.setSoogu(" ");
        if (Strings.isNullOrEmpty(dto.getSummKr().toString())) dto.setSummKr(Long.valueOf(" "));
        if (Strings.isNullOrEmpty(dto.getSummOstZ().toString())) dto.setSummOstZ(Long.valueOf(" "));
        if (Strings.isNullOrEmpty(dto.getSummOstZe().toString())) dto.setSummOstZe(Long.valueOf(" "));
        if (Strings.isNullOrEmpty(dto.getAccOver())) dto.setAccOver(" ");
        if (Strings.isNullOrEmpty(dto.getSummOstprZ().toString())) dto.setSummOstprZ(Long.valueOf(" "));
        if (Strings.isNullOrEmpty(dto.getSummOstprZe().toString())) dto.setSummOstprZe(Long.valueOf(" "));
        if (Strings.isNullOrEmpty(dto.getDateOldPr())) dto.setDateOldPr(" ");
        if (Strings.isNullOrEmpty(dto.getDateLast3())) dto.setDateLast3(" ");
        if (Strings.isNullOrEmpty(dto.getIdsVal())) dto.setIdsVal(" ");
        if (Strings.isNullOrEmpty(dto.getSredName())) dto.setSredName(" ");
        if (Strings.isNullOrEmpty(dto.getSredId())) dto.setSredId(" ");
        if (Strings.isNullOrEmpty(dto.getNameFin())) dto.setNameFin(" ");
        if (Strings.isNullOrEmpty(dto.getAbrSource())) dto.setAbrSource(" ");
        if (Strings.isNullOrEmpty(dto.getTarget())) dto.setTarget(" ");
        if (Strings.isNullOrEmpty(dto.getKolWork())) dto.setKolWork(" ");
        if (Strings.isNullOrEmpty(dto.getShifrId())) dto.setShifrId(" ");
        if (Strings.isNullOrEmpty(dto.getKodOtr())) dto.setKodOtr(" ");
        if (Strings.isNullOrEmpty(dto.getCodeSectorOld())) dto.setCodeSectorOld(" ");
        if (Strings.isNullOrEmpty(dto.getCodeSector())) dto.setCodeSector(" ");
        if (Strings.isNullOrEmpty(dto.getCodeSectorName())) dto.setCodeSectorName(" ");
        if (Strings.isNullOrEmpty(dto.getRate().toString())) dto.setRate(Long.valueOf(" "));
        if (Strings.isNullOrEmpty(dto.getRateDog().toString())) dto.setRateDog(Long.valueOf(" "));
        if (Strings.isNullOrEmpty(dto.getDateToCr())) dto.setDateToCr(" ");
        if (Strings.isNullOrEmpty(dto.getDatLastDb())) dto.setDatLastDb(" ");
        if (Strings.isNullOrEmpty(dto.getSumLastDb().toString())) dto.setSumLastDb(Long.valueOf(" "));
        if (Strings.isNullOrEmpty(dto.getDateClose())) dto.setDateClose(" ");
        if (Strings.isNullOrEmpty(dto.getPogTek().toString())) dto.setPogTek(Long.valueOf(" "));
        if (Strings.isNullOrEmpty(dto.getPogTek1().toString())) dto.setPogTek1(Long.valueOf(" "));
        if (Strings.isNullOrEmpty(dto.getPogTek2().toString())) dto.setPogTek2(Long.valueOf(" "));
        if (Strings.isNullOrEmpty(dto.getGuarName())) dto.setGuarName(" ");
        if (Strings.isNullOrEmpty(dto.getGuarId())) dto.setGuarId(" ");
        if (Strings.isNullOrEmpty(dto.getMaxGuarId())) dto.setMaxGuarId(" ");
        if (Strings.isNullOrEmpty(dto.getSumguarr().toString())) dto.setSumguarr(Long.valueOf(" "));
        if (Strings.isNullOrEmpty(dto.getSumproc().toString())) dto.setSumproc(Double.valueOf(" "));
        if (Strings.isNullOrEmpty(dto.getSumprocEqv().toString())) dto.setSumprocEqv(Double.valueOf(" "));
        if (Strings.isNullOrEmpty(dto.getDateLastPr())) dto.setDateLastPr(" ");
        if (Strings.isNullOrEmpty(dto.getSumnachpr().toString())) dto.setSumnachpr(Double.valueOf(" "));
        if (Strings.isNullOrEmpty(dto.getSumnachprEqv().toString())) dto.setSumnachprEqv(Double.valueOf(" "));
        if (Strings.isNullOrEmpty(dto.getDatL31())) dto.setDatL31(" ");
        if (Strings.isNullOrEmpty(dto.getSummNachPr().toString())) dto.setSummNachPr(Double.valueOf(" "));
        if (Strings.isNullOrEmpty(dto.getSummNachPrS().toString())) dto.setSummNachPrS(Double.valueOf(" "));
        if (Strings.isNullOrEmpty(dto.getAllPog().toString())) dto.setAllPog(Long.valueOf(" "));
        if (Strings.isNullOrEmpty(dto.getSummprodpr())) dto.setSummprodpr(" ");
        if (Strings.isNullOrEmpty(dto.getSummprodprEqv())) dto.setSummprodprEqv(" ");
        if (Strings.isNullOrEmpty(dto.getSummprop())) dto.setSummprop(" ");
        if (Strings.isNullOrEmpty(dto.getSummpropEqv())) dto.setSummpropEqv(" ");
        if (Strings.isNullOrEmpty(dto.getDateFinPr())) dto.setDateFinPr(" ");
        if (Strings.isNullOrEmpty(dto.getOst17().toString())) dto.setOst17(Long.valueOf(" "));
        if (Strings.isNullOrEmpty(dto.getOst46())) dto.setOst46(" ");
        if (Strings.isNullOrEmpty(dto.getOst44())) dto.setOst44(" ");
        if (Strings.isNullOrEmpty(dto.getOst48().toString())) dto.setOst48(Long.valueOf(" "));
        if (Strings.isNullOrEmpty(dto.getSumOst7173())) dto.setSumOst7173(" ");
        if (Strings.isNullOrEmpty(dto.getSumOst7173E())) dto.setSumOst7173E(" ");
        if (Strings.isNullOrEmpty(dto.getDatOld7173())) dto.setDatOld7173(" ");
        if (Strings.isNullOrEmpty(dto.getPNum())) dto.setPNum(" ");
        if (Strings.isNullOrEmpty(dto.getDatePost())) dto.setDatePost(" ");
        if (Strings.isNullOrEmpty(dto.getKlassName())) dto.setKlassName(" ");
        if (Strings.isNullOrEmpty(dto.getKlassKod())) dto.setKlassKod(" ");
        if (Strings.isNullOrEmpty(dto.getSummrez().toString())) dto.setSummrez(Long.valueOf(" "));
        if (Strings.isNullOrEmpty(dto.getSummrezEqv().toString())) dto.setSummrezEqv(Long.valueOf(" "));
        if (Strings.isNullOrEmpty(dto.getFio())) dto.setFio(" ");
        if (Strings.isNullOrEmpty(dto.getSsLdTypeId().toString())) dto.setSsLdTypeId(Long.valueOf(" "));
        if (Strings.isNullOrEmpty(dto.getSsLdTypeName())) dto.setSsLdTypeName(" ");
        if (Strings.isNullOrEmpty(dto.getSsCreditId().toString())) dto.setSsCreditId(Long.valueOf(" "));
        if (Strings.isNullOrEmpty(dto.getSsCreditName())) dto.setSsCreditName(" ");
        if (Strings.isNullOrEmpty(dto.getSCreditKod())) dto.setSCreditKod(" ");
        if (Strings.isNullOrEmpty(dto.getSCreditName())) dto.setSCreditName(" ");
        if (Strings.isNullOrEmpty(dto.getSueDate())) dto.setSueDate(" ");
        if (Strings.isNullOrEmpty(dto.getDecreeDate())) dto.setDecreeDate(" ");
        if (Strings.isNullOrEmpty(dto.getCommentary())) dto.setCommentary(" ");
        if (Strings.isNullOrEmpty(dto.getLawOrganization())) dto.setLawOrganization(" ");
        if (Strings.isNullOrEmpty(dto.getSignOfDesigion())) dto.setSignOfDesigion(" ");
        if (Strings.isNullOrEmpty(dto.getFullName())) dto.setFullName(" ");
        if (Strings.isNullOrEmpty(dto.getKur())) dto.setKur(" ");
        if (Strings.isNullOrEmpty(dto.getTermType())) dto.setTermType(" ");
        if (Strings.isNullOrEmpty(dto.getEmpCount())) dto.setEmpCount(" ");
        if (Strings.isNullOrEmpty(dto.getKodInt())) dto.setKodInt(" ");
        if (Strings.isNullOrEmpty(dto.getEnterpTypeK().toString())) dto.setEnterpTypeK(Long.valueOf(" "));
        if (Strings.isNullOrEmpty(dto.getEnterpTypeN())) dto.setEnterpTypeN(" ");
        if (Strings.isNullOrEmpty(dto.getMinLdGr())) dto.setMinLdGr(" ");
        if (Strings.isNullOrEmpty(dto.getNameActu())) dto.setNameActu(" ");
        if (Strings.isNullOrEmpty(dto.getDateActuClose())) dto.setDateActuClose(" ");
        if (Strings.isNullOrEmpty(dto.getFinCred())) dto.setFinCred(" ");
        if (Strings.isNullOrEmpty(dto.getSumm16405())) dto.setSumm16405(" ");
        if (Strings.isNullOrEmpty(dto.getSumm16413().toString())) dto.setSumm16413(Long.valueOf(" "));
        if (Strings.isNullOrEmpty(dto.getSumm16413Pr())) dto.setSumm16413Pr(" ");
        if (Strings.isNullOrEmpty(dto.getRateUpr())) dto.setRateUpr(" ");
        if (Strings.isNullOrEmpty(dto.getCalcMethod())) dto.setCalcMethod(" ");
        if (Strings.isNullOrEmpty(dto.getReapyDat())) dto.setReapyDat(" ");
        if (Strings.isNullOrEmpty(dto.getRepaySum().toString())) dto.setRepaySum(Long.valueOf(" "));
        if (Strings.isNullOrEmpty(dto.getDateCancel())) dto.setDateCancel(" ");
        if (Strings.isNullOrEmpty(dto.getSummCancel().toString())) dto.setSummCancel(Double.valueOf(" "));
        if (Strings.isNullOrEmpty(dto.getRateProc().toString())) dto.setRateProc(Long.valueOf(" "));
        if (Strings.isNullOrEmpty(dto.getBeginRate())) dto.setBeginRate(" ");
        if (Strings.isNullOrEmpty(dto.getKodFin())) dto.setKodFin(" ");
        if (Strings.isNullOrEmpty(dto.getSummLast3().toString())) dto.setSummLast3(Long.valueOf(" "));
        if (Strings.isNullOrEmpty(dto.getAccV())) dto.setAccV(" ");
        if (Strings.isNullOrEmpty(dto.getSShifrNam())) dto.setSShifrNam(" ");
        if (Strings.isNullOrEmpty(dto.getProdName())) dto.setProdName(" ");
        if (Strings.isNullOrEmpty(dto.getSBranchNam())) dto.setSBranchNam(" ");
        if (Strings.isNullOrEmpty(dto.getAmGuar20().toString())) dto.setAmGuar20(Long.valueOf(" "));
        if (Strings.isNullOrEmpty(dto.getAmGuar21().toString())) dto.setAmGuar21(Long.valueOf(" "));
        if (Strings.isNullOrEmpty(dto.getAmGuar22().toString())) dto.setAmGuar22(Long.valueOf(" "));
        if (Strings.isNullOrEmpty(dto.getAmGuar23().toString())) dto.setAmGuar23(Long.valueOf(" "));
        if (Strings.isNullOrEmpty(dto.getAmGuar24().toString())) dto.setAmGuar24(Long.valueOf(" "));
        if (Strings.isNullOrEmpty(dto.getAmGuar25().toString())) dto.setAmGuar25(Long.valueOf(" "));
        if (Strings.isNullOrEmpty(dto.getAmGuar26().toString())) dto.setAmGuar26(Long.valueOf(" "));
        if (Strings.isNullOrEmpty(dto.getAmGuar27().toString())) dto.setAmGuar27(Long.valueOf(" "));
        if (Strings.isNullOrEmpty(dto.getAmGuar28().toString())) dto.setAmGuar28(Long.valueOf(" "));
        if (Strings.isNullOrEmpty(dto.getAmGuar29().toString())) dto.setAmGuar29(Long.valueOf(" "));
        if (Strings.isNullOrEmpty(dto.getAmGuar30().toString())) dto.setAmGuar30(Long.valueOf(" "));
        if (Strings.isNullOrEmpty(dto.getAmGuar31().toString())) dto.setAmGuar31(Long.valueOf(" "));
        if (Strings.isNullOrEmpty(dto.getAmGuar32().toString())) dto.setAmGuar32(Long.valueOf(" "));
        if (Strings.isNullOrEmpty(dto.getAmGuar33().toString())) dto.setAmGuar33(Long.valueOf(" "));
        if (Strings.isNullOrEmpty(dto.getAmGuar34().toString())) dto.setAmGuar34(Long.valueOf(" "));
        if (Strings.isNullOrEmpty(dto.getAmGuar35().toString())) dto.setAmGuar35(Long.valueOf(" "));
        if (Strings.isNullOrEmpty(dto.getAmGuar36().toString())) dto.setAmGuar36(Long.valueOf(" "));
        if (Strings.isNullOrEmpty(dto.getAmGuar37().toString())) dto.setAmGuar37(Long.valueOf(" "));
        if (Strings.isNullOrEmpty(dto.getAmGuar38().toString())) dto.setAmGuar38(Long.valueOf(" "));
        if (Strings.isNullOrEmpty(dto.getAmGuar39().toString())) dto.setAmGuar39(Long.valueOf(" "));
        if (Strings.isNullOrEmpty(dto.getAmGuar40().toString())) dto.setAmGuar40(Long.valueOf(" "));
        if (Strings.isNullOrEmpty(dto.getAmGuar41().toString())) dto.setAmGuar41(Long.valueOf(" "));
        if (Strings.isNullOrEmpty(dto.getAmGuar42().toString())) dto.setAmGuar42(Long.valueOf(" "));
        if (Strings.isNullOrEmpty(dto.getAmGuar50().toString())) dto.setAmGuar50(Long.valueOf(" "));
        if (Strings.isNullOrEmpty(dto.getAmGuar51().toString())) dto.setAmGuar51(Long.valueOf(" "));
        if (Strings.isNullOrEmpty(dto.getAmGuar60().toString())) dto.setAmGuar60(Long.valueOf(" "));
        if (Strings.isNullOrEmpty(dto.getAmGuar61().toString())) dto.setAmGuar61(Long.valueOf(" "));
        if (Strings.isNullOrEmpty(dto.getDop1001())) dto.setDop1001(" ");
        if (Strings.isNullOrEmpty(dto.getDop1002())) dto.setDop1002(" ");
        if (Strings.isNullOrEmpty(dto.getDop1003())) dto.setDop1003(" ");
        if (Strings.isNullOrEmpty(dto.getDop1004())) dto.setDop1004(" ");
        if (Strings.isNullOrEmpty(dto.getDop1005())) dto.setDop1005(" ");
        if (Strings.isNullOrEmpty(dto.getDop1006())) dto.setDop1006(" ");
        if (Strings.isNullOrEmpty(dto.getDop1007())) dto.setDop1007(" ");
        if (Strings.isNullOrEmpty(dto.getDop1008())) dto.setDop1008(" ");
        if (Strings.isNullOrEmpty(dto.getDop1009())) dto.setDop1009(" ");
        if (Strings.isNullOrEmpty(dto.getDop1010())) dto.setDop1010(" ");
        if (Strings.isNullOrEmpty(dto.getDop1011())) dto.setDop1011(" ");
        if (Strings.isNullOrEmpty(dto.getDop1012())) dto.setDop1012(" ");
        if (Strings.isNullOrEmpty(dto.getDop1013())) dto.setDop1013(" ");
        if (Strings.isNullOrEmpty(dto.getDop1014())) dto.setDop1014(" ");
        if (Strings.isNullOrEmpty(dto.getDop1015())) dto.setDop1015(" ");
        if (Strings.isNullOrEmpty(dto.getDop1016())) dto.setDop1016(" ");
        if (Strings.isNullOrEmpty(dto.getDop1017())) dto.setDop1017(" ");
        if (Strings.isNullOrEmpty(dto.getDop1018())) dto.setDop1018(" ");
        if (Strings.isNullOrEmpty(dto.getDop1019())) dto.setDop1019(" ");
        if (Strings.isNullOrEmpty(dto.getDop1020())) dto.setDop1020(" ");
        if (Strings.isNullOrEmpty(dto.getSummLayPr().toString())) dto.setSummLayPr(Long.valueOf(" "));
        if (Strings.isNullOrEmpty(dto.getSummLayPrEqv().toString())) dto.setSummLayPrEqv(Long.valueOf(" "));
        if (Strings.isNullOrEmpty(dto.getCodeMort())) dto.setCodeMort(" ");
        if (Strings.isNullOrEmpty(dto.getAcompName())) dto.setAcompName(" ");
        if (Strings.isNullOrEmpty(dto.getEvalReportNum())) dto.setEvalReportNum(" ");
        if (Strings.isNullOrEmpty(dto.getIdSsSubsidiary())) dto.setIdSsSubsidiary(" ");
        if (Strings.isNullOrEmpty(dto.getSubsidiary())) dto.setSubsidiary(" ");
        if (Strings.isNullOrEmpty(dto.getSummNachPrNm().toString())) dto.setSummNachPrNm(Double.valueOf(" "));
        if (Strings.isNullOrEmpty(dto.getSummNachPrSNm().toString())) dto.setSummNachPrSNm(Double.valueOf(" "));
        if (Strings.isNullOrEmpty(dto.getCodeBal())) dto.setCodeBal(" ");
        if (Strings.isNullOrEmpty(dto.getDatDelay31())) dto.setDatDelay31(" ");
        if (Strings.isNullOrEmpty(dto.getIdClient())) dto.setIdClient(" ");
        if (Strings.isNullOrEmpty(dto.getAcc09())) dto.setAcc09(" ");
        if (Strings.isNullOrEmpty(dto.getAcc09E())) dto.setAcc09E(" ");
        if (Strings.isNullOrEmpty(dto.getAccond9())) dto.setAccond9(" ");
        if (Strings.isNullOrEmpty(dto.getLastDbR())) dto.setLastDbR(" ");
        if (Strings.isNullOrEmpty(dto.getAhtunN())) dto.setAhtunN(" ");
        if (Strings.isNullOrEmpty(dto.getLoanId().toString())) dto.setLoanId(Long.valueOf(" "));
        if (Strings.isNullOrEmpty(dto.getLoanName())) dto.setLoanName(" ");
        if (Strings.isNullOrEmpty(dto.getAccHoli())) dto.setAccHoli(" ");
        if (Strings.isNullOrEmpty(dto.getHoliSym())) dto.setHoliSym(" ");
        if (Strings.isNullOrEmpty(dto.getAhtunN1())) dto.setAhtunN1(" ");
        if (Strings.isNullOrEmpty(dto.getAhtunN2())) dto.setAhtunN2(" ");
        if (Strings.isNullOrEmpty(dto.getPassportSn())) dto.setPassportSn(" ");

        return dto;
    };


}
