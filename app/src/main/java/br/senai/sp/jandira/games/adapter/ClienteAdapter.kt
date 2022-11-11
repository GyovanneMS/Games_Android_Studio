package br.senai.sp.jandira.games.adapter

//class ClienteAdapter (var infosCliente: Cliente, var context: Context): RecyclerView.Adapter<ClienteAdapter.ClienteInfos>() {
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClienteInfos {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_game_list, parent, false);
//        return ClienteInfos(view);
//    }
//
//
//    override fun onBindViewHolder(holder: ClienteInfos, position: Int) {
//        val cliente = infosCliente[position]
//
//        holder.textName.text = cliente.nome;
//        holder.textAge.text = cliente.telefone;
//        holder.textEmail.text = cliente.email;
//        holder.textLevel.text = cliente.nome.substring(0, 1);
//
//    override fun getItemCount(): Int {
//        return infosCliente.size;
//    }
//
//    class ClienteInfos(view: View): RecyclerView.ViewHolder(view) {
//        val textName = view.findViewById<TextView>(R.id.textView_user_name);
//        val textEmail = view.findViewById<TextView>(R.id.textView_user_email);
//        val textAge = view.findViewById<TextView>(R.id.textAge);
//        val textLevel = view.findViewById<TextView>(R.id.textLevel);
//    }
//
//}