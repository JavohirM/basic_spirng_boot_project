package uz.writer.dao.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.*;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@ToString
public class PortLd10Model {


    @SerializedName("ldId")
    @JsonProperty("LD_ID")

    private Long ldId;
    @SerializedName("sbor")
    @JsonProperty("SBOR")

    private String sbor;
    @SerializedName("statusName")
    @JsonProperty("STATUS_NAME")

    private String statusName;
    @SerializedName("nClaim")
    @JsonProperty("N_CLAIM")

    private String nClaim;
    @SerializedName("reqNCode")
    @JsonProperty("REQ_N_CODE")

    private String reqNCode;
    @SerializedName("account")
    @JsonProperty("ACCOUNT")

    private String account;
    @SerializedName("idsRegion")
    @JsonProperty("IDS_REGION")

    private String idsRegion;
    @SerializedName("branchNam")
    @JsonProperty("BRANCH_NAM")

    private String branchNam;
    @SerializedName("clientName")
    @JsonProperty("CLIENT_NAME")

    private String clientName;
    @SerializedName("tipCl")
    @JsonProperty("TIP_CL")

    private String tipCl;
    @SerializedName("tipClKod")
    @JsonProperty("TIP_CL_KOD")

    private String tipClKod;
    @SerializedName("useBranch")
    @JsonProperty("USE_BRANCH")

    private String useBranch;
    @SerializedName("taxRegistr")
    @JsonProperty("TAX_REGISTR")

    private String taxRegistr;
    @SerializedName("birthday")
    @JsonProperty("BIRTHDAY")

    private String birthday;
    @SerializedName("distr")
    @JsonProperty("DISTR")

    private String distr;
    @SerializedName("distrName")
    @JsonProperty("DISTR_NAME")

    private String distrName;
    @SerializedName("nActNumNew")
    @JsonProperty("N_ACT_NUM_NEW")

    private String nActNumNew;
    @SerializedName("nActDateNew")
    @JsonProperty("N_ACT_DATE_NEW")

    private String nActDateNew;
    @SerializedName("crcNum")
    @JsonProperty("CRC_NUM")

    private String crcNum;
    @SerializedName("crcDate")
    @JsonProperty("CRC_DATE")

    private String crcDate;
    @SerializedName("pNum1")
    @JsonProperty("P_NUM1")

    private String pNum1;
    @SerializedName("pDate")
    @JsonProperty("P_DATE")

    private String pDate;
    @SerializedName("ldAmount")
    @JsonProperty("LD_AMOUNT")

    private Long ldAmount;
    @SerializedName("ldAmountEqv")
    @JsonProperty("LD_AMOUNT_EQV")

    private Long ldAmountEqv;
    @SerializedName("nameguarr")
    @JsonProperty("NAMEGUARR")

    private String nameguarr;
    @SerializedName("distSum")
    @JsonProperty("DIST_SUM")

    private Long distSum;
    @SerializedName("distSumEqv")
    @JsonProperty("DIST_SUM_EQV")

    private Long distSumEqv;
    @SerializedName("distSumY")
    @JsonProperty("DIST_SUM_Y")

    private String distSumY;
    @SerializedName("distSumYEqv")
    @JsonProperty("DIST_SUM_Y_EQV")

    private String distSumYEqv;
    @SerializedName("nalBez")
    @JsonProperty("NAL_BEZ")

    private Long nalBez;
    @SerializedName("datDelay")
    @JsonProperty("DAT_DELAY")

    private String datDelay;
    @SerializedName("kolDeb2")
    @JsonProperty("KOL_DEB_2")

    private Long kolDeb2;
    @SerializedName("soogu")
    @JsonProperty("SOOGU")

    private String soogu;
    @SerializedName("summKr")
    @JsonProperty("SUMM_KR")

    private Long summKr;
    @SerializedName("summOstZ")
    @JsonProperty("SUMM_OST_Z")

    private Long summOstZ;
    @SerializedName("summOstZe")
    @JsonProperty("SUMM_OST_ZE")

    private Long summOstZe;
    @SerializedName("accOver")
    @JsonProperty("ACC_OVER")

    private String accOver;
    @SerializedName("summOstprZ")
    @JsonProperty("SUMM_OSTPR_Z")

    private Long summOstprZ;
    @SerializedName("summOstprZe")
    @JsonProperty("SUMM_OSTPR_ZE")

    private Long summOstprZe;
    @SerializedName("dateOldPr")
    @JsonProperty("DATE_OLD_PR")

    private String dateOldPr;
    @SerializedName("dateLast3")
    @JsonProperty("DATE_LAST_3")

    private String dateLast3;
    @SerializedName("idsVal")
    @JsonProperty("IDS_VAL")

    private String idsVal;
    @SerializedName("sredName")
    @JsonProperty("SRED_NAME")

    private String sredName;
    @SerializedName("sredId")
    @JsonProperty("SRED_ID")

    private String sredId;
    @SerializedName("nameFin")
    @JsonProperty("NAME_FIN")

    private String nameFin;
    @SerializedName("abrSource")
    @JsonProperty("ABR_SOURCE")

    private String abrSource;
    @SerializedName("target")
    @JsonProperty("TARGET")

    private String target;
    @SerializedName("kolWork")
    @JsonProperty("KOL_WORK")

    private String kolWork;
    @SerializedName("shifrId")
    @JsonProperty("SHIFR_ID")

    private String shifrId;
    @SerializedName("kodOtr")
    @JsonProperty("KOD_OTR")

    private String kodOtr;
    @SerializedName("codeSectorOld")
    @JsonProperty("CODE_SECTOR_OLD")

    private String codeSectorOld;
    @SerializedName("codeSector")
    @JsonProperty("CODE_SECTOR")

    private String codeSector;
    @SerializedName("codeSectorName")
    @JsonProperty("CODE_SECTOR_NAME")

    private String codeSectorName;
    @SerializedName("rate")
    @JsonProperty("RATE")

    private Long rate;
    @SerializedName("rateDog")
    @JsonProperty("RATE_DOG")

    private Long rateDog;
    @SerializedName("dateToCr")
    @JsonProperty("DATE_TO_CR")

    private String dateToCr;
    @SerializedName("datLastDb")
    @JsonProperty("DAT_LAST_DB")

    private String datLastDb;
    @SerializedName("sumLastDb")
    @JsonProperty("SUM_LAST_DB")

    private Long sumLastDb;
    @SerializedName("dateClose")
    @JsonProperty("DATE_CLOSE")

    private String dateClose;
    @SerializedName("pogTek")
    @JsonProperty("POG_TEK")

    private Long pogTek;
    @SerializedName("pogTek1")
    @JsonProperty("POG_TEK_1")

    private Long pogTek1;
    @SerializedName("pogTek2")
    @JsonProperty("POG_TEK_2")

    private Long pogTek2;
    @SerializedName("guarName")
    @JsonProperty("GUAR_NAME")

    private String guarName;
    @SerializedName("guarId")
    @JsonProperty("GUAR_ID")

    private String guarId;
    @SerializedName("maxGuarId")
    @JsonProperty("MAX_GUAR_ID")

    private String maxGuarId;
    @SerializedName("sumguarr")
    @JsonProperty("SUMGUARR")

    private Long sumguarr;
    @SerializedName("sumproc")
    @JsonProperty("SUMPROC")

    private Double sumproc;
    @SerializedName("sumprocEqv")
    @JsonProperty("SUMPROC_EQV")

    private Double sumprocEqv;
    @SerializedName("dateLastPr")
    @JsonProperty("DATE_LAST_PR")

    private String dateLastPr;
    @SerializedName("sumnachpr")
    @JsonProperty("SUMNACHPR")

    private Double sumnachpr;
    @SerializedName("sumnachprEqv")
    @JsonProperty("SUMNACHPR_EQV")

    private Double sumnachprEqv;
    @SerializedName("datL31")
    @JsonProperty("DAT_L_31")

    private String datL31;
    @SerializedName("summNachPr")
    @JsonProperty("SUMM_NACH_PR")

    private Double summNachPr;
    @SerializedName("summNachPrS")
    @JsonProperty("SUMM_NACH_PR_S")

    private Double summNachPrS;
    @SerializedName("allPog")
    @JsonProperty("ALL_POG")

    private Long allPog;
    @SerializedName("summprodpr")
    @JsonProperty("SUMMPRODPR")

    private String summprodpr;
    @SerializedName("summprodprEqv")
    @JsonProperty("SUMMPRODPR_EQV")

    private String summprodprEqv;
    @SerializedName("summprop")
    @JsonProperty("SUMMPROP")

    private String summprop;
    @SerializedName("summpropEqv")
    @JsonProperty("SUMMPROP_EQV")

    private String summpropEqv;
    @SerializedName("dateFinPr")
    @JsonProperty("DATE_FIN_PR")

    private String dateFinPr;
    @SerializedName("ost17")
    @JsonProperty("OST_17")

    private Long ost17;
    @SerializedName("ost46")
    @JsonProperty("OST_46")

    private String ost46;
    @SerializedName("ost44")
    @JsonProperty("OST_44")

    private String ost44;
    @SerializedName("ost48")
    @JsonProperty("OST_48")

    private Long ost48;
    @SerializedName("sumOst7173")
    @JsonProperty("SUM_OST_71_73")

    private String sumOst7173;
    @SerializedName("sumOst7173E")
    @JsonProperty("SUM_OST_71_73_E")

    private String sumOst7173E;
    @SerializedName("datOld7173")
    @JsonProperty("DAT_OLD_71_73")

    private String datOld7173;
    @SerializedName("pNum")
    @JsonProperty("P_NUM")

    private String pNum;
    @SerializedName("datePost")
    @JsonProperty("DATE_POST")

    private String datePost;
    @SerializedName("klassName")
    @JsonProperty("KLASS_NAME")

    private String klassName;
    @SerializedName("klassKod")
    @JsonProperty("KLASS_KOD")

    private String klassKod;
    @SerializedName("summrez")
    @JsonProperty("SUMMREZ")

    private Long summrez;
    @SerializedName("summrezEqv")
    @JsonProperty("SUMMREZ_EQV")

    private Long summrezEqv;
    @SerializedName("fio")
    @JsonProperty("FIO")

    private String fio;
    @SerializedName("ssLdTypeId")
    @JsonProperty("SS_LD_TYPE_ID")

    private Long ssLdTypeId;
    @SerializedName("ssLdTypeName")
    @JsonProperty("SS_LD_TYPE_NAME")

    private String ssLdTypeName;
    @SerializedName("ssCreditId")
    @JsonProperty("SS_CREDIT_ID")

    private Long ssCreditId;
    @SerializedName("ssCreditName")
    @JsonProperty("SS_CREDIT_NAME")

    private String ssCreditName;
    @SerializedName("sCreditKod")
    @JsonProperty("S_CREDIT_KOD")

    private String sCreditKod;
    @SerializedName("sCreditName")
    @JsonProperty("S_CREDIT_NAME")

    private String sCreditName;
    @SerializedName("sueDate")
    @JsonProperty("SUE_DATE")

    private String sueDate;
    @SerializedName("decreeDate")
    @JsonProperty("DECREE_DATE")

    private String decreeDate;
    @SerializedName("commentary")
    @JsonProperty("COMMENTARY")

    private String commentary;
    @SerializedName("lawOrganization")
    @JsonProperty("LAW_ORGANIZATION")

    private String lawOrganization;
    @SerializedName("signOfDesigion")
    @JsonProperty("SIGN_OF_DESIGION")

    private String signOfDesigion;
    @SerializedName("fullName")
    @JsonProperty("FULL_NAME")

    private String fullName;
    @SerializedName("kur")
    @JsonProperty("KUR")

    private String kur;
    @SerializedName("termType")
    @JsonProperty("TERM_TYPE")

    private String termType;
    @SerializedName("empCount")
    @JsonProperty("EMP_COUNT")

    private String empCount;
    @SerializedName("kodInt")
    @JsonProperty("KOD_INT")

    private String kodInt;
    @SerializedName("enterpTypeK")
    @JsonProperty("ENTERP_TYPE_K")

    private Long enterpTypeK;
    @SerializedName("enterpTypeN")
    @JsonProperty("ENTERP_TYPE_N")

    private String enterpTypeN;
    @SerializedName("minLdGr")
    @JsonProperty("MIN_LD_GR")

    private String minLdGr;
    @SerializedName("nameActu")
    @JsonProperty("NAME_ACTU")

    private String nameActu;
    @SerializedName("dateActuClose")
    @JsonProperty("DATE_ACTU_CLOSE")

    private String dateActuClose;
    @SerializedName("finCred")
    @JsonProperty("FIN_CRED")

    private String finCred;
    @SerializedName("summ16405")
    @JsonProperty("SUMM_16405")

    private String summ16405;
    @SerializedName("summ16413")
    @JsonProperty("SUMM_16413")

    private Long summ16413;
    @SerializedName("summ16413Pr")
    @JsonProperty("SUMM_16413_PR")

    private String summ16413Pr;
    @SerializedName("rateUpr")
    @JsonProperty("RATE_UPR")

    private String rateUpr;
    @SerializedName("calcMethod")
    @JsonProperty("CALC_METHOD")

    private String calcMethod;
    @SerializedName("reapyDat")
    @JsonProperty("REAPY_DAT")

    private String reapyDat;
    @SerializedName("repaySum")
    @JsonProperty("REPAY_SUM")

    private Long repaySum;
    @SerializedName("dateCancel")
    @JsonProperty("DATE_CANCEL")

    private String dateCancel;
    @SerializedName("summCancel")
    @JsonProperty("SUMM_CANCEL")

    private Double summCancel;
    @SerializedName("rateProc")
    @JsonProperty("RATE_PROC")

    private Long rateProc;
    @SerializedName("beginRate")
    @JsonProperty("BEGIN_RATE")

    private String beginRate;
    @SerializedName("kodFin")
    @JsonProperty("KOD_FIN")

    private String kodFin;
    @SerializedName("summLast3")
    @JsonProperty("SUMM_LAST_3")

    private Long summLast3;
    @SerializedName("accV")
    @JsonProperty("ACC_V")

    private String accV;
    @SerializedName("sShifrNam")
    @JsonProperty("S_SHIFR_NAM")

    private String sShifrNam;
    @SerializedName("prodName")
    @JsonProperty("PROD_NAME")

    private String prodName;
    @SerializedName("sBranchNam")
    @JsonProperty("S_BRANCH_NAM")

    private String sBranchNam;
    @SerializedName("amGuar20")
    @JsonProperty("AM_GUAR_20")

    private Long amGuar20;
    @SerializedName("amGuar21")
    @JsonProperty("AM_GUAR_21")

    private Long amGuar21;
    @SerializedName("amGuar22")
    @JsonProperty("AM_GUAR_22")

    private Long amGuar22;
    @SerializedName("amGuar23")
    @JsonProperty("AM_GUAR_23")

    private Long amGuar23;
    @SerializedName("amGuar24")
    @JsonProperty("AM_GUAR_24")

    private Long amGuar24;
    @SerializedName("amGuar25")
    @JsonProperty("AM_GUAR_25")

    private Long amGuar25;
    @SerializedName("amGuar26")
    @JsonProperty("AM_GUAR_26")

    private Long amGuar26;
    @SerializedName("amGuar27")
    @JsonProperty("AM_GUAR_27")

    private Long amGuar27;
    @SerializedName("amGuar28")
    @JsonProperty("AM_GUAR_28")

    private Long amGuar28;
    @SerializedName("amGuar29")
    @JsonProperty("AM_GUAR_29")

    private Long amGuar29;
    @SerializedName("amGuar30")
    @JsonProperty("AM_GUAR_30")

    private Long amGuar30;
    @SerializedName("amGuar31")
    @JsonProperty("AM_GUAR_31")

    private Long amGuar31;
    @SerializedName("amGuar32")
    @JsonProperty("AM_GUAR_32")

    private Long amGuar32;
    @SerializedName("amGuar33")
    @JsonProperty("AM_GUAR_33")

    private Long amGuar33;
    @SerializedName("amGuar34")
    @JsonProperty("AM_GUAR_34")

    private Long amGuar34;
    @SerializedName("amGuar35")
    @JsonProperty("AM_GUAR_35")

    private Long amGuar35;
    @SerializedName("amGuar36")
    @JsonProperty("AM_GUAR_36")

    private Long amGuar36;
    @SerializedName("amGuar37")
    @JsonProperty("AM_GUAR_37")

    private Long amGuar37;
    @SerializedName("amGuar38")
    @JsonProperty("AM_GUAR_38")

    private Long amGuar38;
    @SerializedName("amGuar39")
    @JsonProperty("AM_GUAR_39")

    private Long amGuar39;
    @SerializedName("amGuar40")
    @JsonProperty("AM_GUAR_40")

    private Long amGuar40;
    @SerializedName("amGuar41")
    @JsonProperty("AM_GUAR_41")

    private Long amGuar41;
    @SerializedName("amGuar42")
    @JsonProperty("AM_GUAR_42")

    private Long amGuar42;
    @SerializedName("amGuar43")
    @JsonProperty("AM_GUAR_43")

    private Long amGuar43;
    @SerializedName("amGuar50")
    @JsonProperty("AM_GUAR_50")

    private Long amGuar50;
    @SerializedName("amGuar51")
    @JsonProperty("AM_GUAR_51")

    private Long amGuar51;
    @SerializedName("amGuar60")
    @JsonProperty("AM_GUAR_60")

    private Long amGuar60;
    @SerializedName("amGuar61")
    @JsonProperty("AM_GUAR_61")

    private Long amGuar61;
    @SerializedName("dop1001")
    @JsonProperty("DOP_1001")

    private String dop1001;
    @SerializedName("dop1002")
    @JsonProperty("DOP_1002")

    private String dop1002;
    @SerializedName("dop1003")
    @JsonProperty("DOP_1003")

    private String dop1003;
    @SerializedName("dop1004")
    @JsonProperty("DOP_1004")

    private String dop1004;
    @SerializedName("dop1005")
    @JsonProperty("DOP_1005")

    private String dop1005;
    @SerializedName("dop1006")
    @JsonProperty("DOP_1006")

    private String dop1006;
    @SerializedName("dop1007")
    @JsonProperty("DOP_1007")

    private String dop1007;
    @SerializedName("dop1008")
    @JsonProperty("DOP_1008")

    private String dop1008;
    @SerializedName("dop1009")
    @JsonProperty("DOP_1009")

    private String dop1009;
    @SerializedName("dop1010")
    @JsonProperty("DOP_1010")

    private String dop1010;
    @SerializedName("dop1011")
    @JsonProperty("DOP_1011")

    private String dop1011;
    @SerializedName("dop1012")
    @JsonProperty("DOP_1012")

    private String dop1012;
    @SerializedName("dop1013")
    @JsonProperty("DOP_1013")

    private String dop1013;
    @SerializedName("dop1014")
    @JsonProperty("DOP_1014")

    private String dop1014;
    @SerializedName("dop1015")
    @JsonProperty("DOP_1015")

    private String dop1015;
    @SerializedName("dop1016")
    @JsonProperty("DOP_1016")

    private String dop1016;
    @SerializedName("dop1017")
    @JsonProperty("DOP_1017")

    private String dop1017;
    @SerializedName("dop1018")
    @JsonProperty("DOP_1018")

    private String dop1018;
    @SerializedName("dop1019")
    @JsonProperty("DOP_1019")

    private String dop1019;
    @SerializedName("dop1020")
    @JsonProperty("DOP_1020")

    private String dop1020;
    @SerializedName("summLayPr")
    @JsonProperty("SUMM_LAY_PR")

    private Long summLayPr;
    @SerializedName("summLayPrEqv")
    @JsonProperty("SUMM_LAY_PR_EQV")

    private Long summLayPrEqv;
    @SerializedName("codeMort")
    @JsonProperty("CODE_MORT")

    private String codeMort;
    @SerializedName("acompName")
    @JsonProperty("ACOMP_NAME")

    private String acompName;
    @SerializedName("evalReportNum")
    @JsonProperty("EVAL_REPORT_NUM")

    private String evalReportNum;
    @SerializedName("idSsSubsidiary")
    @JsonProperty("ID_SS_SUBSIDIARY")

    private String idSsSubsidiary;
    @SerializedName("subsidiary")
    @JsonProperty("SUBSIDIARY")

    private String subsidiary;
    @SerializedName("summNachPrNm")
    @JsonProperty("SUMM_NACH_PR_NM")

    private Double summNachPrNm;
    @SerializedName("summNachPrSNm")
    @JsonProperty("SUMM_NACH_PR_S_NM")

    private Double summNachPrSNm;
    @SerializedName("codeBal")
    @JsonProperty("CODE_BAL")

    private String codeBal;
    @SerializedName("datDelay31")
    @JsonProperty("DAT_DELAY_31")

    private String datDelay31;
    @SerializedName("idClient")
    @JsonProperty("ID_CLIENT")

    private String idClient;
    @SerializedName("acc09")
    @JsonProperty("ACC_09")

    private String acc09;
    @SerializedName("acc09E")
    @JsonProperty("ACC_09_E")

    private String acc09E;
    @SerializedName("accond9")
    @JsonProperty("ACCOND_9")

    private String accond9;
    @SerializedName("lastDbR")
    @JsonProperty("LAST_DB_R")

    private String lastDbR;
    @SerializedName("ahtunN")
    @JsonProperty("AHTUN_N")

    private String ahtunN;
    @SerializedName("loanId")
    @JsonProperty("LOAN_ID")

    private Long loanId;
    @SerializedName("loanName")
    @JsonProperty("LOAN_NAME")

    private String loanName;
    @SerializedName("accHoli")
    @JsonProperty("ACC_HOLI")

    private String accHoli;
    @SerializedName("holiSym")
    @JsonProperty("HOLI_SYM")

    private String holiSym;
    @SerializedName("ahtunN1")
    @JsonProperty("AHTUN_N_1")

    private String ahtunN1;
    @SerializedName("ahtunN2")
    @JsonProperty("AHTUN_N_2")

    private String ahtunN2;
    @SerializedName("passportSn")
    @JsonProperty("PASSPORT_SN")

    private String passportSn;
}
