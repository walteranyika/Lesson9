package com.walter.lesson9;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class MainActivity extends Activity {
	ListView list;
	CustomAdapter adapter;
	int pos = 0;
	int upper_limit = 10;
	String[] data = {
			"haha... ati grandmasako ni wa zamo mpaka alisahau handbag yake kwa Ark ya Noah ",
			"ati wewe ni dingo hadi ukipita na fone ya mse hurudi bila feature ya MPESA ",
			"Ati wewe ni mjinga ulipanda mti ndio ukuwe branch manager ",
			"wewe ni mbroke kila saa hadi simu yako iko na M-deni badala ya M-pesa ",
			"ati paka yenu ni holy design ma panya ziki kam ina zi sendia email ati woiye pls tokeni hapa? ",
			"Naskia wesewe ni black hadi ile siku God ali kuumba alisema oops have burnt one ",
			"Ati naskia nagos yako ni chinku hadi ikona game inaitwa Thika road ",
			"Ati naskia ukona sura mbaya hadi traffic police ukusmamisha daily akikuuliza hii accident ulireporti kweli? ",
			"Ati naskia teli yenyu nipyenga hadi nyinyi huwatch na straw.. ",
			"Ati naskia kwenyu kunawagondi hadi gate mumeiweka kwa hao.....haahaaa ",
			"Sistako ni mdogo hadi akimeza njugu anakaa nikama akona ball ",
			"Ati kwenyu kumekauka hadi hamuezi bonga matope ",
			"Ati naskia grandbudako amezeeka hadi yeye huishi kwa museum.. ",
			"Ati naskia nyinyi kwenyu mumesota hadi nyinyi hukula ugali na story za nyama ",
			"Naskia wewe ni fala siku moja ukiwa kwa court iliskia judge akisema order in court ukaitisha kebab na coke ",
			"Ati wewe ni fala kunasiku ulichukuwa ruler ukaenda nayo bed ndio uangalie umelala masaa mangapi ",
			"Ati wesewe ni fala hadi ukitaka kumeza dawa wewe hukata kando ndio usipate side effects ",
			"Ati wesewe ni mchafu hadi ukienda kwa lake kuswim fish hutoka kutema mate ",
			"Ati ninaskia sistako ni mnono hadi wewe humwita 2 in a million ",
			"Ati wewe ni fala uliulizwa wingi wa mawe ukasema kokoto ",
			"Dem yako ni fala yeye hu vaa pencil na rubber na hapendi kusoma ",
			"Ati naskia budako yeye hukuwa ndedhe lakini yeye hu insist ku pocket ",
			"Ati naskia dem yako akimeza mate yeye hu nyora ",
			"Ati ninaskia siku yako ya fao kunyonji ulikimbia hosi ukidhani wewe ni msick ",
			"Hao yenyu ni mzee hadi mume ishikilia na stand ya bike ",
			"Ati naskia chali yako ni fala hadi yeye huweka radio kwa fridge ndio askize cool muzik ",
			"Bazenga wako ni fala yeye huhepa job kuenda kuswing na gate ",
			"radio yenu hushika petrol station ",
			"TV yenu imezeeka mpaka ikiwashwa lazima muisukume. ",
			"manzi yako ni mjinga hadi akafail pregnancy test ",
			"dem wako ni fala hadi aliomba DJ kwa club mchezee ile ngoma ya progi ya inspekta mwala ",
			"Ati naskia grandmasako ni mzee hadi magova walimnyanganya ID ",
			"Dem yako nimu argly hadi akilia machozi zinaenda na nyuma ",
			"Kwenyu nyinyi ni wa jinga hadi jirani akiwasalimia muna discuss answere ",
			"Ati naskia wesewe ni mpyenga hadi wewe huenda mountain haike kwa pevu ",
			"Ati dem yako nimweusi hadi chameleon ikimuangukia inachanganyikiwa ",
			"Ati naskia bazenga wako ni mtall hadi akitafuta loose ya thao yeye hutafuta kwa wadhii wa ndege ",
			"nkt! una maaaringo na we mblak design uki smile una kaa kama njahi! ",
			"wewe ni mzee hadi birth cert yako imeandikwa kwa leaves ",
			"dem yako ana boobs bwaku hadi yeye uvalia bra long sleeved ",
			"Ati naskia wewe ni mjinga hadi ulirepeat naso mara mbili ",
			"Ati dem yako akona sura mbaya hadi yeye huadmitiwa kwa store ya hosi ",
			"Ati wewe ni fala hadi ulidangaya jina yako kwa exam ",
			"ati kwenu ni ocha hadi samosa zenyu ni za githeri ",
			"Wewe ni mfake hadi simu yako ilipozimwa SIM card iliungua ",
			"nkt! kwenda huko! una ringa na niliskia ati we ni mfala umezoea kuride bike design uki panda mat una kunja mguu moja ya rodhi ",
			"Manzi yako ni mshamba siku ya Bday yake ulimshow happy birth day naye akakujibu you too.. ",
			"Ati naskia masako amekonda hadi budako akimuhag anaonekana nika amevaa tai ",
			"nini umekimya hivyo? kwani umesota hadi simu yako ime rust memory ya kuweka airtime. ",
			"Una mkono rough hadi ukishika mouse computer inadai found new hardware. ",
			"Umezoea kula mogoka hadi unaogopa kumeza mboga ",
			"Ati wewe nimchafu mpaka ukiingia kwa lake kuswim fish zinatoka kutema mate ",
			"Ati umezoea kuokoa jahazi hadi safcom hukuuliza utahama lini? ",
			"Ati Unakipara ukivaa polo neck unakaa roll on ",
			"Ati wewe ni mzee hadi ukizaliwa OLD TESTAMENT ilikuwa inaitwa TESTAMENT ",
			"Umezoea kutumia wasee please call me mpaka ukipress *130* simu ukutolea phone book ujichagulie. ",
			"We ni dentist mpro hadi unangoa blue tooth ya phone yako. ",
			"Ati wewe mweusi tu sana mpaka hauna bright ideas. ",
			"Ati mtoi wenu alizaliwa akiwa mblack mpaka doki akasema Kameungua. ",
			"We ni mkonda hadi uki dance helicopter una take off... ",
			"UKo na macho kubwa hadi wewe huitwa eye witness ",
			"uko na macho kubwa hadi unaitwa eye witness ",
			"we ni mweusi mpaka ukishika mtoi anadoze akidhani ni usiku. ",
			"ati we ni mfat hadi unaamka na sessions ",
			"We ni mshamba vile uliskia comps inaeza pata virus uliibuyia condom ",
			"ati nyumba yako ni mzee hadi imeshikiliwa na stand ya bike ",
			"ati we ni mshamba hadi huweka redio kwa fridge ndo uskie cool musik ",
			"kichwa yako ni kubwa badala ya kujifunga bandana unajifunga bedsheet. ",
			"Manzi yako ana a** ndogo akitashu u move mbele. ",
			"ati jo! uko na mguu ka smal mpaka huwezi kanyangia risto za baze ",
			"manzi yako anakichwa biggy hadi akienda salon ye hushukwa style zote ",
			"Ati we ni mzee hadi insted ya kuchukua ID we hurudisha! ",
			"We ni mnono hadi ukikalia ashu inakuwa five bob mbili ",
			"Nyanyako ni mapengo criaaas hadi anabondewa maji. ",
			"ti we ni mu ugly hadi unainvitiwa kwa mazishi ndio wa2 walie ",
			"uko na kisogo kubwa mpaka ukiangalia juu inaingia kwa mfuko ya nyuma ",
			"Una mkono nono hadi vidole zako zote ni thumbs. ",
			"we ni mweusi hadi ukichomwa na jua unanuka firestone. ",
			"mko wengi instead of kutumia bafu mnaenda cattle dip. ",
			"Eti keja yako ni kidogo mpaka umechora viti kwa wall. ",
			"Budako ni mdosi hadi ana kipara mbili. ",
			"una macho biggy hadi ukiblink zinalia ëbonyi bonyií !! ",
			"manzi yako ni msupa badala ya kumea fudhi ye humea ma flowers ",
			"ati we ni mkonde mpaka ukiingia class watoi huwika oooonnnneeeee!!! ",
			"Ati we ni mkonde badala ya mbu kukuuma hudonate zikisema îHe needs it mo than we doî ",
			"ATI UMECHANUKA HADI FUDHI UMEZINYOA MOHAWK ",
			"Dame wako amebeat hadi hufunga always na suspenders! ",
			"Ati we ni mjinga hadi ukienda kwa hoteli unauliza ka kuna mayai alafu unadai upewe mama yake ",
			"Nyanyako mzee alizaliwa rainbow ikiwa blak n white ",
			"We ni msee wa choir damu hadi we hushuta desyn ya vigelegele alililililiiiii ",
			"we ni mchoyo hadi we utema mate kwa wallet. ",
			"ati uko na masikio bigi tym ya kuzaliwa ulishikwa ka cup ya UEFA. ",
			"Ati we ni mneat phone yako iko na curtains ",
			"we ni mweusi ukijipaka vaseline unakaa ni ka umevaa leather jacket. ",
			"phone yako mzee ikivibrate SMS zinamwagikaÖ ",
			"una kichwa delicate hadi ukifikiria maskio zinaingia ndani ",
			"kichwa yako kubwa hadi ina-appear kwa ID both sides ndio itoshee ",
			"ati meno zako zina spaces mob mpaka ulimi yako inakaa ni kama iko kwa jela ",
			"Manzi yako mnono hadi ukimchinjia lazima umuingize box tatu ",
			"nyumba yenu ni ndogo mpaka nyi hutake turns kubreathe ",
			"ati mko wengi design nyi hulala kwa kitanda mkiwa mmejipanga ka vibiriti ",
			"Mlango ya hao yenu ni soo nyinyi hufungua wall instead ",
			"naskia haukuzaliwa ulitangazwa kwa radio ",
			"wewe ni mrefu mpaka skin yako ina ishia kwa magoti ",
			"TV yenu ni nzee mpaka mnaizima na maji ",
			"unajipaka make up mob ukilia unaacha erosion ",
			"Ati wewe ni mkonda mpaka ukienda toile unatumia uzi badala ya tissue!!! ",
			"Wewe ni mzee hadi id numba yako iko na roman numberzÖ.. ",
			"haga ya dame wako ni small mpaka unamdara na tweezer ",
			"ati mbuyu wa u ni mstingy ye uphotocopy socks zake ndio asave wode ya kuosha ",
			"manzi yako ana ulimi ingine rough mpaka akiongea yeye huskip kama CD ",
			"ati wewe ni mkondi hadi ukishuta una sikia uchungu ",
			"Ati wewe ni mfupi mpaka unakata cabbage na ngazi? ",
			"dame wako ni mshake hadi ulipomnunulia radio ya kwanza alibanjuka hadi newz ",
			"wewe ni mwizi mpaka unaji ibia kutoka kwa mfuko ya right una weka kwa ya left ",
			"Kwenu ni ocha mpaka mathree hutandika vitambaa kwa viti ",
			"Ati computer yako ni slow hadi wewe huiwasha asubuhi ili uweze kuwatch movie usiku ",
			"Umezoea kutuma plis call mpaka mathegi walikuja kwenu ukatuma *130*999# ",
			"wewe ni mnono watu hufanya tizi by runnin around u ",
			"Mbuyu wako ni mnono akikalia hashu akiamka inakuwa kobole mbili ",
			"Ati ngozi yako mbaya inakaa kama combat! ",
			"una kichwa kubwa mpaka ukikimbia unabaki umefloat ",
			"Budako fala ulimtuma kitabu ya class 8 akaleta mbili za class 4 ",
			"ati wee ni m old hadi marks zako za kcpe ziliandikwa kwa stone tablets ",
			"Dame yako ana lips kubwa mpaka anatumia roll on ka lip balm ",
			"We ni ìmgalenjin orichinol hadi chogoo zenu huwiga ëgogorigoooíî ",
			"Ati nyumba yenyu ni kombo mpaka ukilala asubuhi unajipata nnje ",
			"Ati una sura mbaya ukilia machozi zinaenda juu ",
			"Ngotha yako chuma ikiingia lunch unaitoa na spark ",
			"Ati wewe mkonde ukiinua mkono unaona maminyoo zikikatiana ",
			"Nyinyi ni mababi mpaka mnaweka sufuria zenyu kwa saucer ",
			"Nyinyi ni mababi mpaka muna hao ya glass ambayo ina madirisha ya mawe ",
			"Ati wewe ni mfupi sana hadi uki pigwa picha lazima camera man alale kwa floor ",
			"Ati nyanyako ni mblack design venye alijoin ma brownie yeye alibaki ame itwa ìblackieî ",
			"Kwenu nyi ni mafala hadi mna patia kuku zenu maji moto ati ndio zitoe mayai boilo ",
			"Nyumba yenu ni round lakini mnafight kulala back left ",
			"Gari yeni ni noma siku za mvua inavaa gumboots ",
			"Mobile 4n yako ni kali mpaka inamixx ma ringtones ",
			"Mko wadosi mpaka ngíombe zenu huvalishwa Trust condoms zikienda kulala ",
			"Mbuyu wako huhepa job kwenda kuswing na gate ",
			"Nyinyi wengi kwa family yenu mpaka munaweka bumps musigongane ",
			"wewe mweusi mpaka ukirushiwa mawe inarudi kuitisha torch! ",
			"Wewe in mweusi hadi ukitoka nje giza inasema mmh ",
			"Nyinyi mko poor mpaka kwa 10 bob zenu Moi amevaa vest imeraruka. ",
			"ati wewe ni mweusi mpaka badal ya wasee kukuita wao huimbai le advert ya kiwi hebu kitokeze jionyease simama mbele ya watu... ",
			"nyanyako mzee mpaka viatu zake zinasema Air Moses and the Burning Bush ",
			"Kwenyu nyinyi ni wengi mpaka lazima utoke nje kuchange mind " };
	ArrayList<Item> arrayList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		list = (ListView) findViewById(R.id.listView1);
		arrayList = new ArrayList<Item>();
		adapter = new CustomAdapter(this, arrayList);
		list.setAdapter(adapter);

		for (pos = 0; pos < upper_limit; pos++) {
			Item x = new Item("Position " + pos, data[pos]);
			arrayList.add(x);
		}

		Log.d("POSITION", String.valueOf(pos));

		adapter.notifyDataSetChanged();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	
		Log.d("SIZE", ""+arrayList.size());
		if (item.getItemId() == R.id.action_settings) 
		{
			arrayList.clear();
			upper_limit += 10;
			for (pos = 0; pos < upper_limit; pos++) 
			{
				Item x = new Item("Position " + pos, data[pos]);
				arrayList.add(x);
			}
		}
		return super.onOptionsItemSelected(item);
	}

}
